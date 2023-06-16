#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define LEFTROTATE(x, n) (((x) << (n)) | ((x) >> (32 - (n))))

void ripemd128(const uint8_t *data, size_t length, uint8_t *hash) {
    // Initial values
    uint32_t h[4] = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476};

    // Constants
    uint32_t k1[4] = {0x00000000, 0x5A827999, 0x6ED9EBA1, 0x8F1BBCDC};
    uint32_t k2[4] = {0x50A28BE6, 0x5C4DD124, 0x6D703EF3, 0x00000000};

    // Message padding
    uint32_t padded_length = ((length + 8 + 63) / 64) * 64;
    uint8_t *padded_data = (uint8_t *)calloc(padded_length, sizeof(uint8_t));
    memcpy(padded_data, data, length);
    padded_data[length] = 0x80;
    uint64_t bit_length = length * 8;
    memcpy(padded_data + padded_length - 8, &bit_length, sizeof(uint64_t));

    // Message processing
    for (size_t i = 0; i < padded_length; i += 64) {
        uint32_t *w = (uint32_t *)(padded_data + i);
        uint32_t a = h[0], b = h[1], c = h[2], d = h[3];

        for (size_t j = 0; j < 64; j++) {
            uint32_t temp;
            if (j < 16) {
                temp = a + (b ^ c ^ d) + w[j] + k1[0];
            } else if (j < 32) {
                temp = a + ((b & c) | (~b & d)) + w[(5 * j + 1) % 16] + k1[1];
            } else if (j < 48) {
                temp = a + ((b | ~c) ^ d) + w[(3 * j + 5) % 16] + k1[2];
            } else {
                temp = a + (b ^ (c | ~d)) + w[(7 * j) % 16] + k1[3];
            }

            uint32_t temp2 = b + LEFTROTATE(temp, k2[j / 16]);
            a = d;
            d = c;
            c = b;
            b = temp2;
        }

        h[0] += a;
        h[1] += b;
        h[2] += c;
        h[3] += d;
    }

    // Output hash
    uint32_t *hash32 = (uint32_t *)hash;
    for (size_t i = 0; i < 4; i++) {
        *hash32++ = h[i];
    }

    free(padded_data);
}

void print_hash(const uint8_t *hash) {
	printf("I am hashing this text with ripemd 128\n");
    for (int i = 0; i < 16; i++) {
        printf("%02x", hash[i]);
    }
    printf("\n");
}

int main() {
    // Example usage
    uint8_t message[] = "I am hashing this text with ripemd 128";
    uint8_t hash[16];
    ripemd128(message, sizeof(message) - 1, hash);
    print_hash(hash);
    return 0;
}
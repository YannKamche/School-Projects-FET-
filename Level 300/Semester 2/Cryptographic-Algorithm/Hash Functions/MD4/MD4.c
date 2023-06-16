#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#define MD4_BLOCK_SIZE 64
#define MD4_DIGEST_SIZE 16

typedef struct {
    uint32_t state[4];
    uint32_t count[2];
    uint8_t buffer[MD4_BLOCK_SIZE];
} md4_ctx;

static const uint32_t K[] = {
    0x5a827999, 0x6ed9eba1, 0x8f1bbcdc, 0xa953fd4e
};

static inline uint32_t ROTL(uint32_t x, uint32_t n) {
    return (x << n) | (x >> (32 - n));
}

static inline uint32_t F(uint32_t x, uint32_t y, uint32_t z) {
    return (x & y) | (~x & z);
}

static inline uint32_t G(uint32_t x, uint32_t y, uint32_t z) {
    return (x & y) | (x & z) | (y & z);
}

static inline uint32_t H(uint32_t x, uint32_t y, uint32_t z) {
    return x ^ y ^ z;
}

static void transform(md4_ctx *ctx, const uint8_t *data) {
    uint32_t a = ctx->state[0];
    uint32_t b = ctx->state[1];
    uint32_t c = ctx->state[2];
    uint32_t d = ctx->state[3];
    uint32_t x[MD4_BLOCK_SIZE / 4];

    for (int i = 0; i < MD4_BLOCK_SIZE / 4; i++) {
        x[i] = ((uint32_t)data[i * 4]) |
               ((uint32_t)data[i * 4 + 1] << 8) |
               ((uint32_t)data[i * 4 + 2] << 16) |
               ((uint32_t)data[i * 4 + 3] << 24);
    }

    for (int i = 0; i < 16; i++) {
        uint32_t tmp = d;
        d = c;
        c = b;
        b = b + ROTL((a + F(b, c, d) + x[i]), 3);
        a = tmp;
    }

    for (int i = 16; i < 32; i++) {
        uint32_t tmp = d;
        d = c;
        c = b;
        b = b + ROTL((a + G(b, c, d) + x[(5 * i + 1) % 16]), 5);
        a = tmp;
    }

    for (int i = 32; i < 48; i++) {
        uint32_t tmp = d;
        d = c;
        c = b;
        b = b + ROTL((a + H(b, c, d) + x[(3 * i + 5) % 16]), 9);
        a = tmp;
    }

    for (int i = 48; i < 64; i++) {
        uint32_t tmp = d;
        d = c;
        c = b;
        b = b + ROTL((a + G(b, c, d) + x[(7 * i) % 16]), 13);
        a = tmp;
    }

    ctx->state[0] += a;
    ctx->state[1] += b;
    ctx->state[2] += c;
    ctx->state[3] += d;
}

static void md4_init(md4_ctx *ctx) {
    ctx->state[0] = 0x67452301;
    ctx->state[1] = 0xefcdab89;
    ctx->state[2] = 0x98badcfe;
    ctx->state[3] = 0x10325476;
    ctx->count[0] = 0;
    ctx->count[1] = 0;
}

static void md4_update(md4_ctx *ctx, const uint8_t *data, size_t len) {
    uint32_t i, idx, part_len;

    idx = (uint32_t)((ctx->count[0] >> 3) & 0x3f);

    if ((ctx->count[0] += len << 3) < (len << 3)) {
        ctx->count[1]++;
    }

    ctx->count[1] += (len >> 29);

    part_len = 64 - idx;

    if (len >= part_len) {
        memcpy(&ctx->buffer[idx], data, part_len);
        transform(ctx, ctx->buffer);

        for (i = part_len; i + 63 < len; i += 64) {
            transform(ctx, &data[i]);
        }

        idx = 0;
    } else {
        i = 0;
    }

    memcpy(&ctx->buffer[idx], &data[i], len - i);
}

static void md4_final(md4_ctx *ctx, uint8_t *digest) {
    uint8_t bits[8];
    uint32_t idx, pad_len;

    for (int i = 0; i < 8; i++) {
        bits[i] = (uint8_t)((ctx->count[i >> 2] >> ((i & 3) << 3)) & 0xff);
    }

    idx = (uint32_t)((ctx->count[0] >> 3) & 0x3f);
    pad_len = (idx < 56) ? (56 - idx) : (120 - idx);

    md4_update(ctx, (const uint8_t*)"\x80", 1);

    while (pad_len--) {
        md4_update(ctx, (const uint8_t*)"\0", 1);
    }

    md4_update(ctx, bits, 8);

    for (int i = 0; i < 4; i++) {
        digest[i] = (uint8_t)(ctx->state[0] >> (i * 8));
        digest[i + 4] = (uint8_t)(ctx->state[1] >> (i * 8));
        digest[i + 8] = (uint8_t)(ctx->state[2] >> (i * 8));
        digest[i + 12] = (uint8_t)(ctx->state[3] >> (i * 8));
    }
}

void md4(const uint8_t *data, size_t len, uint8_t *digest) {
    md4_ctx ctx;
    md4_init(&ctx);
    md4_update(&ctx, data, len);
    md4_final(&ctx, digest);
}

int main() {
    uint8_t message[] = "I am hashing this statement with MD4";
    uint8_t digest[MD4_DIGEST_SIZE];

    md4(message, strlen((char*)message), digest);

    printf("MD4 hash of \"%s\":\n", message);

    for (int i = 0; i < MD4_DIGEST_SIZE; i++) {
        printf("%02x", digest[i]);
    }

    printf("\n");

    return 0;
}
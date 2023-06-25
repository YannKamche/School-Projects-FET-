#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function declarations
void caesar_cipher(char* message, int key, int encrypt);

int main() {
    char message[100];
    int key;

    // Prompt the user for the message and key
    printf("Enter a message to encrypt: ");
    fgets(message, sizeof(message), stdin);
    printf("Enter a key value (1-25): ");
    scanf("%d", &key);

    // Encrypt the message
    caesar_cipher(message, key, 1);
    printf("Encrypted message: %s\n", message);

    // Decrypt the message
    caesar_cipher(message, key, 0);
    printf("Decrypted message: %s\n", message);

    return 0;
}

// Function to apply the Caesar Cipher to a message
void caesar_cipher(char* message, int key, int encrypt) {
    int len = strlen(message);
    for (int i = 0; i < len; i++) {
        if (isalpha(message[i])) {
            // Determine the base value for uppercase or lowercase letters
            char base = isupper(message[i]) ? 'A' : 'a';
            // Apply the Caesar Cipher shift
            char shifted = ((message[i] - base + (encrypt ? key : 26 - key)) % 26) + base;
            message[i] = shifted;
        }
    }
}
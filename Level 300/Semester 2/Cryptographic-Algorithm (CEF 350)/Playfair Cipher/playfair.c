#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define SIZE 5

// Function to generate the Playfair matrix from the key
void generateKeyTable(char key[], char keyTable[SIZE][SIZE]) {
    // Initialize the key table with '0'
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            keyTable[i][j] = '0';
        }
    }

    // Fill the key table with the key
    int length = strlen(key);
    int index = 0;
    for (int i = 0; i < length; i++) {
        if (key[i] == 'j') {
            key[i] = 'i';
        }

        if (!isalpha(key[i])) {
            continue;
        }

        int row = index / SIZE;
        int col = index % SIZE;
        keyTable[row][col] = key[i];
        index++;
    }

    // Fill the rest of the key table with the remaining letters
    char c = 'a';
    for (int i = index; i < SIZE * SIZE; i++) {
        int row = i / SIZE;
        int col = i % SIZE;

        while (strchr(key, c) != NULL || c == 'j') {
            c++;
        }

        keyTable[row][col] = c;
        c++;
    }
}

// Function to encrypt a plaintext message using the Playfair Cipher
void encrypt(char message[], char keyTable[SIZE][SIZE]) {
    int length = strlen(message);

    // Replace 'j' with 'i'
    for (int i = 0; i < length; i++) {
        if (message[i] == 'j') {
            message[i] = 'i';
        }
    }

    // Add an 'x' between two consecutive identical letters
    int index = 0;
    while (index < length - 1) {
        if (message[index] == message[index + 1]) {
            memmove(&message[index + 1], &message[index + 1], strlen(&message[index + 1]) + 1);
            message[index + 1] = 'x';
            length++;
        }

        index += 2;
    }

    // If the length of the plaintext is odd, add an 'x' at the end
    if (length % 2 != 0) {
        message[length] = 'x';
        length++;
    }

    // Encrypt the plaintext
    for (int i = 0; i < length; i += 2) {
        int row1, col1, row2, col2;

        // Find the positions of the two characters in the key table
        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                if (keyTable[j][k] == message[i]) {
                    row1 = j;
                    col1 = k;
                } else if (keyTable[j][k] == message[i + 1]) {
                    row2 = j;
                    col2 = k;
                }
            }
        }

        // Apply the Playfair Cipher rules to the two characters
        if (row1 == row2) { // Same row
            printf("%c%c", keyTable[row1][(col1 + 1) % SIZE], keyTable[row2][(col2 + 1) % SIZE]);
        } else if (col1 == col2) { // Same column
            printf("%c%c", keyTable[(row1 + 1) % SIZE][col1], keyTable[(row2 + 1) % SIZE][col2]);
        } else { // Form a rectangle
            printf("%c%c", keyTable[row1][col2], keyTable[row2][col1]);
        }
    }
}

int main() {
    char key[SIZE * SIZE];
    char keyTable[SIZE][SIZE];
    char message[SIZE * SIZE];

    // Prompt the user for the key and the plaintext message
    printf("Enter the key: ");
    fgets(key, sizeof(key), stdin);
    key[strcspn(key, "\n")] = 0;

    printf("Enter the message: ");
    fgets(message, sizeof(message), stdin);
    message[strcspn(message, "\n")] = 0;

    // Generate the key table from the key
    generateKeyTable(key, keyTable);

    // Encrypt the plaintext message using the Playfair Cipher
    printf("Encrypted text: ");
    encrypt(message, keyTable);

    return 0;
}
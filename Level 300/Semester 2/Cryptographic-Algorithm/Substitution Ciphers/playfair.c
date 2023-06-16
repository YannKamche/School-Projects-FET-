#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define KEY_SIZE 25
#define GRID_SIZE 5


void createKeyTable(char key[], char keyTable[GRID_SIZE][GRID_SIZE]) {
    
    int i, j, k;
    int len = strlen(key);
    int row = 0, col = 0;
    int used[26] = {0};

    for (k = 0; k < len; k++) {
        if (key[k] == 'j') {
            key[k] = 'i';
        }

        if (!isalpha(key[k])) {
            continue;
        }

        if (!used[key[k] - 'a']) {
            keyTable[row][col] = key[k];
            used[key[k] - 'a'] = 1;
            col++;

            if (col == GRID_SIZE) {
                col = 0;
                row++;
            }
        }
    }

    for (i = 0; i < 26; i++) {
        if (i == ('j' - 'a')) {
            continue;
        }

        if (!used[i]) {
            keyTable[row][col] = i + 'a';
            col++;

            if (col == GRID_SIZE) {
                col = 0;
                row++;
            }
        }
    }
}


void encrypt(char message[], char keyTable[GRID_SIZE][GRID_SIZE], char encrypted[]) {
    int i, j, k;
    int len = strlen(message);
    int newLen = 0;
    char c1, c2;
    int row1, col1, row2, col2;

 
    for (i = 0; i < len; i++) {
        if (message[i] == 'j') {
            message[i] = 'i';
        }
    }

  
    for (i = 0; i < len; i += 2) {
        c1 = message[i];
        c2 = message[i + 1];
        row1 = col1 = row2 = col2 = -1;

        for (j = 0; j < GRID_SIZE; j++) {
            for (k = 0; k < GRID_SIZE; k++) {
                if (keyTable[j][k] == c1) {
                    row1 = j;
                    col1 = k;
                }

                if (keyTable[j][k] == c2) {
                    row2 = j;
                    col2 = k;
                }
            }
        }

        if (row1 == row2) { // Same row
            encrypted[newLen++] = keyTable[row1][(col1 + 1) % GRID_SIZE];
            encrypted[newLen++] = keyTable[row1][(col2 + 1) % GRID_SIZE];
        } else if (col1 == col2) { // Same column
            encrypted[newLen++] = keyTable[(row1 + 1) % GRID_SIZE][col1];
            encrypted[newLen++] = keyTable[(row2 + 1) % GRID_SIZE][col1];
        } else { // Form a rectangle
            encrypted[newLen++] = keyTable[row1][col2];
            encrypted[newLen++] = keyTable[row2][col1];
        }
    }

    encrypted[newLen] = '\0';
}

int main() {
    char key[KEY_SIZE] = {'\0'};
    char keyTable[GRID_SIZE][GRID_SIZE] = {{'\0'}};
    char message[KEY_SIZE] = {'\0'};
    char encrypted[KEY_SIZE * 2] = {'\0'};

    printf("Enter the key: ");
    fgets(key, KEY_SIZE, stdin);
    key[strcspn(key, "\n")] = '\0';
    printf("Enter the message: ");
    fgets(message, KEY_SIZE, stdin);
    message[strcspn(message, "\n")] = '\0';
    createKeyTable(key, keyTable);
    encrypt(message, keyTable, encrypted);
    printf("Encrypted message: %s\n", encrypted);

    return 0;
}

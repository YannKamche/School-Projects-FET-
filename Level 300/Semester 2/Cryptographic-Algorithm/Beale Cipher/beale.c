#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_WORDS 1000
#define MAX_DIGITS 10

typedef struct {
    int page;
    int line;
    int word;
} Ciphertext;

int read_ciphertext(char *filename, Ciphertext *ciphertexts, int num_ciphertexts);
void decode_ciphertext(char *book_filename, Ciphertext *ciphertexts, int num_ciphertexts);

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <ciphertext_file> <book_file>\n", argv[0]);
        return 1;
    }

    char *ciphertext_filename = argv[1];
    char *book_filename = argv[2];

    Ciphertext ciphertexts[3];
    int num_ciphertexts = read_ciphertext(ciphertext_filename, ciphertexts, 3);

    if (num_ciphertexts != 3) {
        printf("Error: Expected 3 ciphertexts, but found %d\n", num_ciphertexts);
        return 1;
    }

    decode_ciphertext(book_filename, ciphertexts, 3);

    return 0;
}

int read_ciphertext(char *filename, Ciphertext *ciphertexts, int num_ciphertexts) {
    FILE *fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Error: Could not open file '%s'\n", filename);
        return 0;
    }

    int i;
    for (i = 0; i < num_ciphertexts; i++) {
        if (fscanf(fp, "%d,%d,%d", &ciphertexts[i].page, &ciphertexts[i].line, &ciphertexts[i].word) != 3) {
            printf("Error: Invalid ciphertext in file '%s'\n", filename);
            fclose(fp);
            return i;
        }
    }

    fclose(fp);
    return i;
}

void decode_ciphertext(char *book_filename, Ciphertext *ciphertexts, int num_ciphertexts) {
    FILE *fp = fopen(book_filename, "r");
    if (fp == NULL) {
        printf("Error: Could not open file '%s'\n", book_filename);
        return;
    }

    char word[MAX_DIGITS + 1];
    int page = 0;
    int line = 0;
    int word_num = 0;
    int i;

    while (fgets(word, MAX_DIGITS + 1, fp) != NULL) {
        int len = strlen(word);
        if (len > 0 && word[len-1] == '\n') {
            word[len-1] = '\0';
        }

        word_num++;

        if (word_num > MAX_WORDS) {
            printf("Error: Book file contains too many words\n");
            fclose(fp);
            return;
        }

        if (strcmp(word, "PAGE") == 0) {
            if (fscanf(fp, "%d", &page) != 1) {
                printf("Error: Invalid book file format\n");
                fclose(fp);
                return;
            }
            line = 0;
            word_num = 0;
        } else if (strcmp(word, "LINE") == 0) {
            if (fscanf(fp, "%d", &line) != 1) {
                printf("Error: Invalid book file format\n");
                fclose(fp);
                return;
            }
            word_num = 0;
        } else {
            for (i = 0; i < num_ciphertexts; i++) {
                if (page == ciphertexts[i].page && line == ciphertexts[i].line && word_num == ciphertexts[i].word) {
                    printf("%d ", i);
                    break;
                }
            }
        }
    }

    fclose(fp);
}
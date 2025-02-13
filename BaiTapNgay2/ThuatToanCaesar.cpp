#include <stdio.h>
#include <string.h>
//NGUYEN BA VIET
void encrypt(char text[], int shift) {
    for (int i = 0; i < strlen(text); i++) {
        if (text[i] >= 'A' && text[i] <= 'Z') {
            text[i] = (text[i] - 'A' + shift) % 26 + 'A';
        } else if (text[i] >= 'a' && text[i] <= 'z') {
            text[i] = (text[i] - 'a' + shift) % 26 + 'a';
        }
    }
}

void decrypt(char text[], int shift) {
    for (int i = 0; i < strlen(text); i++) {
        if (text[i] >= 'A' && text[i] <= 'Z') {
            text[i] = (text[i] - 'A' - shift + 26) % 26 + 'A';
        } else if (text[i] >= 'a' && text[i] <= 'z') {
            text[i] = (text[i] - 'a' - shift + 26) % 26 + 'a';
        }
    }
}
//NGUYEN BA VIET
int main() {
    char text[100];
    int shift;
    printf("Nhap van ban: ");
    gets(text);

    printf("Nhap khoang dich chuyen: ");
    scanf("%d", &shift);

    encrypt(text, shift);
    printf("Van ban mã hóa: %s\n", text);

    decrypt(text, shift);
    printf("Van ban giai mã: %s\n", text);

    return 0;
}


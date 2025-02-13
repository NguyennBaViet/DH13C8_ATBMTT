#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// NGUYEN BA VIET
char randomAlphaChar() {
    char chars[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return chars[rand() % 52];
}

char randomDigit() {
    return '0' + (rand() % 10);
}

char randomAlphaNumChar() {
    int r = rand() % 3;
    if (r == 0) return randomDigit();
    return randomAlphaChar();
}

void generateOTP(int length, char* otp) {
    for (int i = 0; i < length; i++) {
        otp[i] = randomAlphaNumChar();
    }
}

int main() {
    srand(time(0));  
    int length = 8;
    char otp[length + 1];

    generateOTP(length, otp);

    printf("Ma OTP cua ban là: %s\n", otp);

    return 0;
}


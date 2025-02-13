#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Hàm d? nhân ma tr?n
vector<int> matrixMultiply(const vector<vector<int>>& key, const vector<int>& text) {
    vector<int> result(2, 0);
    result[0] = (key[0][0] * text[0] + key[0][1] * text[1]) % 26;
    result[1] = (key[1][0] * text[0] + key[1][1] * text[1]) % 26;
    return result;
}

// Hàm mã hóa Hill
string hillCipherEncrypt(const string& plaintext, const vector<vector<int>>& key) {
    string ciphertext = "";
    int n = plaintext.length();
    for (int i = 0; i < n; i += 2) {
        vector<int> block = {plaintext[i] - 'A', (i + 1 < n) ? plaintext[i + 1] - 'A' : 0};
        vector<int> encryptedBlock = matrixMultiply(key, block);
        ciphertext += (encryptedBlock[0] + 'A');
        ciphertext += (encryptedBlock[1] + 'A');
    }
    return ciphertext;
}

int main() {
    vector<vector<int>> key = {{6, 24}, {13, 16}}; // Khóa K c? 2x2
    string plaintext = "HELP"; // Van b?n g?c

    string ciphertext = hillCipherEncrypt(plaintext, key);
    cout << "Ciphertext: " << ciphertext << endl;

    return 0;
}

#include <iostream>
#include <cmath>

using namespace std;

long long gcd(long long a, long long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

long long modInverse(long long a, long long m) {
    long long m0 = m, t, q;
    long long x0 = 0, x1 = 1;

    if (m == 1)
        return 0;

    while (a > 1) {
        q = a / m;
        t = m;

        m = a % m, a = t;
        t = x0;
        x0 = x1 - q * x0;
        x1 = t;
    }

    if (x1 < 0)
        x1 += m0;

    return x1;
}

int main() {
    // Two prime numbers
    long long p = 61;
    long long q = 53;

    // Calculate n
    long long n = p * q;

    // Calculate Euler's Totient Function
    long long phi = (p - 1) * (q - 1);

    // Public key e
    long long e = 17;

    // Calculate private key d
    long long d = modInverse(e, phi);

    cout << "Public key (n, e): (" << n << ", " << e << ")" << endl;
    cout << "Private key (n, d): (" << n << ", " << d << ")" << endl;

    return 0;
}


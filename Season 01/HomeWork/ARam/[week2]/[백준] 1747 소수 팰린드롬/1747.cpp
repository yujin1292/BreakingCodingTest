#include <iostream>
#include <cmath>
#include <string>
#include <cstring>
#define MAX 2000001
using namespace std;

bool isPrime[MAX];

void checkPrime(int n) {
	memset(isPrime, 1, sizeof(isPrime));
	isPrime[0] = isPrime[1] = false;

	for (int i = 2; i <= sqrt(n); i++) {
		if (isPrime[i]) {
			for (int j = i * i; j <= n; j += i) {
				isPrime[j] = false;
			}
		}
	}
}

bool isPalindrome(int n) {
	string s1 = to_string(n);
	string s2 = "";

	for (int i = s1.length() - 1; i >= 0; i--) {
		s2 += s1[i];
	}
	if (s1 == s2)
		return true;

	return false;
}

int main() {
	int N;
	cin >> N;

	checkPrime(MAX - 1);
	while (true) {
		if (isPrime[N] && isPalindrome(N)) { // 제일 먼저 찾은 수가 최소값
			cout << N;
			break;
		}
		N++;
	}

	return 0;
}
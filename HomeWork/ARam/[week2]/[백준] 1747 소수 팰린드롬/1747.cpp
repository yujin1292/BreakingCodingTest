#include <iostream>
#include <cmath>
#include <string>
#define MAX 1000000
using namespace std;

bool isPrime(int n) {
	if (n == 1)
		return false;
	if (n == 2)
		return true;
	if (n % 2 == 0)
		return false;

	for (int i = 3; i <= sqrt(n); i += 2) {
		if (n % i == 0)
			return false;
	}

	return true;
}

bool isPalindrome(int n) {
	string s1 = to_string(n);
	string s2 = "";
	if (s1.length() < 2)
		return false;

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

	for (int i = N; i <= MAX; i++) {
		if (isPrime(i) && isPalindrome(i)) { // 제일 먼저 찾은 수가 최소값
			cout << i;
			break;
		}
	}

	return 0;
}
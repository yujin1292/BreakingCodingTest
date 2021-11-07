#include <iostream>
#include <cmath>
#define MAX 10000
using namespace std;

int prime[MAX];

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

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;
	int min = 9999;
	int sum = 0;
	cin >> M >> N;

	for (int i = M; i <= N; i++) {
		prime[i] = isPrime(i);
		if (prime[i] == true) { // ¼Ò¼ö
			sum += i;
			if (i < min)
				min = i;
		}
	}

	if (sum == 0)
		cout << -1 << "\n";
	else
		cout << sum << "\n" << min;

	return 0;
}
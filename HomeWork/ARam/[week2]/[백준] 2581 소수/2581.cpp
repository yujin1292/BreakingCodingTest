#include <iostream>
#include <cmath>
#include <cstring>
#define MAX 10001
using namespace std;

bool isPrime[MAX];

void check(int n) {
	memset(isPrime, 1, sizeof(isPrime));
	isPrime[0] = isPrime[1] = false;

	for (int i = 2; i < sqrt(n); i++) {
		if (isPrime[i]) {
			for (int j = i * i; j <= n; j += i) {
				isPrime[j] = false;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;
	int min = 9999;
	int sum = 0;
	cin >> M >> N;

	check(N);
	for (int i = M; i <= N; i++) {
		if (isPrime[i] == true) { // ¼Ò¼ö
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
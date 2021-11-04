#include <iostream>
#include <cmath>

using namespace std;

int M, N;
int prime[1000001];

int main() {

	cin >> M >> N;

	for (int i = M; i <= N; i++) {
		prime[i] = i;
	}

	prime[1] = 0;

	for (int i = 2; i <= (int)sqrt(N); i++) {
		for (int j = 2 * i; j <= N; j += i)
			prime[j] = 0;
	}

	for (int i = M; i <= N; i++) {
		if (prime[i] != 0)
			cout << i << '\n';
	}

	system("pause");
	return 0;
}
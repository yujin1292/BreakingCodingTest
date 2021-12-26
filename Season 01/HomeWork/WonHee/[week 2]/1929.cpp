#include <iostream>
#include <cmath>

using namespace std;

int M, N;
int prime[1000001];

int main() {

	cin >> M >> N;

	memset(prime, 1, sizeof(prime));

	prime[0] = prime[1] = false;

	for (int i = 2; i <= (int)(sqrt(1000000)); i++) {
		if (prime[i]) {
			for (int j = i * i; j <= 1000000; j += i)
				prime[j] = false;
		}
	}

	for (int i = M; i <= N; i++) {
		if (prime[i])
			cout << i << '\n';
	}

	system("pause");
	return 0;
}

#include <iostream>
#include <cmath>

using namespace std;

int M, N;
int prime[10001];
int sum=0;
int minn=10001;

int main() {

	cin >> M;
	cin >> N;

	memset(prime, 1, sizeof(prime));

	prime[0] = prime[1] = false;

	for (int i = 2; i <= (int)(sqrt(10000)); i++) {
		if (prime[i]) {
			for (int j = i * i; j <= 10000; j += i)
				prime[j] = false;
		}
	}

	for (int i = M; i <= N; i++) {
		if (prime[i]) {
			sum += i;
			if (minn > i)
				minn = i;
		}
	}

	if (sum == 0) {
		minn = -1;
		cout << minn;
	}
	else
		cout << sum << '\n' << minn;

	system("pause");
	return 0;
}

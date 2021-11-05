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

	for (int i = M; i <= N; i++) {
		prime[i] = i;
	}

	prime[1] = 0;

	for (int i = 2; i <= (int)sqrt(N); i++) {
		for (int j = 2 * i; j <= N; j += i)
			prime[j] = 0;
	}

	for (int i = M; i <= N; i++) {
		if (prime[i] != 0) {
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
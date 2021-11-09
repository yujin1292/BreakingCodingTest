#include <iostream>
#include <cmath>
#include <string>
#include <cstring>

using namespace std;


int N;
int prime[2000001];

bool same(int x) {
	string s = to_string(x);
	int i = 0;
	int j = s.length()-1;
	
	while (j-i>0) {
		if (s[i] != s[j]) {
			return false;
		}
		else {
			i++;
			j--;
		}
	}
	return true;
}

void isPrime() {
	memset(prime, 1, sizeof(prime));

	prime[0] = prime[1] = false;

	for (int i = 2; i <= (int)(sqrt(2000000)); i++) {
		if (prime[i]) {
			for (int j = i * i; j <= 2000000; j += i)
				prime[j] = false;
		}
	}
}

int main() {
	cin >> N;

	isPrime();

	int i = N;
	while (1) {
		if (prime[i] && same(i)) {
			cout << i;
			break;
		}
		i++;
	}

	system("pause");
	return 0;
}

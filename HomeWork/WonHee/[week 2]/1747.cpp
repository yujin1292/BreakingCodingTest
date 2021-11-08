#include <iostream>
#include <cmath>
#include <string>

using namespace std;


// Æ²·È¾î¿ä¿À¿À¿À¿Á ÈæÈæ........................


int N;
int prime[1000001];

bool same(int x) {
	string s = to_string(x);
	int i = 0;
	int j = s.size()-1;
	
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

int main() {
	cin >> N;

	prime[0] = prime[1] = 1;

	for (int i = 2; i <= (int)sqrt(N); i++) {
		for (int j = 2 * i; j <= 1000000; j += i)
			prime[j] = 1;
	}

	for (int i = N; i <= 1000000; i++) {
		if (prime[i] == 0) {
			if (same(i)) {
				cout << i;
				system("pause");
				return 0;
			}
		}
	}
}
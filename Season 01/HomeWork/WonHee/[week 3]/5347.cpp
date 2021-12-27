#include <iostream>

using namespace std;

long long a, b;
long n;
long res;

long long GCD(long long x, long long y) {
	int temp;
	int smaller = x > y ? y : x;
	int bigger = x > y ? x : y;

	while (smaller != 0) {
		int rest = bigger % smaller;
		bigger = smaller;
		smaller = rest;
	}
	return bigger;
}

long long LCM(long a, long b) {
	return (a*b) / GCD(a, b);
}

int main() {

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		res = LCM(a, b);
		cout << res << "\n";
	}

	system("pause");
	return 0;
}
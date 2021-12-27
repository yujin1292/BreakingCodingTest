#include <iostream>

using namespace std;

long long a, b;

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
	cin >> a >> b;

	cout << GCD(a,b) << "\n";
	cout << LCM(a, b) << "\n";

	system("pause");
	return 0;
}
#include <iostream>

using namespace std;

long long gcd(long long a, long long b) {
	if (b == 0)
		return a;
	else
		return gcd(b, a % b);
}

long long lcm(long long a, long long b) {
	long long g = gcd(a, b);
	return  (a*b)/g;
}

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		long long a, b;
		cin >> a >> b;
		
		if (a > b)
			cout << lcm(a, b) << endl;
		else
			cout << lcm(b, a) << endl;
	}


	return 0;
}
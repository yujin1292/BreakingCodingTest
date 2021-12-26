#include <iostream>

using namespace std;

int gcd(int a, int b) {
	if (b == 0) return a;
	else
		return gcd(b, a % b);
}

int lcm(int a, int b, int g) {
	return (a*b) / g;
}

int main() {
	int a, b, g;

	cin >> a >> b;

	if (a > b)
		g = gcd(a, b);
	else
		g = gcd(b, a);

	cout << g << endl << lcm(a, b, g);

	return 0;
}
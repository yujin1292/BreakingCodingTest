
int gcd(int x, int y) {
	int temp;
	int smaller = x > y ? y : x; 
	int bigger = x > y ? x : y; 

	while ( smaller != 0) {
		int rest = bigger % smaller;
		bigger = smaller;
		smaller = rest;
	}
	return bigger;
}

int lmc(int a, int b) {
	return (a * b) / gcd(a, b);
}
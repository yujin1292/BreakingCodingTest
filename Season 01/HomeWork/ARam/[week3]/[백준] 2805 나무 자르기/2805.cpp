#include <iostream>
#include <vector>
using namespace std;

vector<long> tree;
int N, M;

long cut(long m) {
	long sum = 0;
	for (auto t : tree) {
		if (t > m)
			sum += (t - m);
	}

	return sum;
}


long b_search(long s, long e) {
	long m = (s + e) / 2;

	if (s > e)
		return e;

	if (cut(m) < M)
		return b_search(s, m - 1); // 더 많이 자르기

	else
		return b_search(m + 1, e); // 더 적게 자르기

}

int main() {
	long max = -1;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		long n;
		cin >> n;
		tree.push_back(n);
		
		if (n > max)
			max = n;
	}
	cout << b_search(0, max);

	return 0;
}
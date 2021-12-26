#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v;

int b_search(int s, int e, int n) {
	if (s >= e) {
		if (n == v.at(s))
			return 1;
		else
			return 0;
	}

	int m = (s + e) / 2;

	if (n == v.at(m))
		return 1;

	if (n > v.at(m))
		return b_search(m + 1, e, n);

	else
		return b_search(s, m - 1, n);
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;

	cin >> N;

	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		v.push_back(n);
	}

	sort(v.begin(), v.end());

	cin >> M;

	for (int i = 0; i < M; i++) {
		int n;
		cin >> n;
		cout << b_search(0, N - 1, n) << "\n";
	}

	return 0;
}
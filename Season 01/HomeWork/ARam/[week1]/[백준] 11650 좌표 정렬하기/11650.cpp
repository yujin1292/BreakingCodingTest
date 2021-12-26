#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector <pair<int, int> > v;

int main() {
	int N, x, y;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end());

	for (auto e : v) {
		cout << e.first << " " << e.second << "\n";
	}

	return 0;
}
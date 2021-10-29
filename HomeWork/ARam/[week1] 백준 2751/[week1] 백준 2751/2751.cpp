#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> v;

int main() {
	int N, num;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> num;
		v.push_back(num);
	}

	// quick-sort
	sort(v.begin(), v.end());

	for (auto e : v) {
		cout << e << "\n";
	}

	return 0;
}
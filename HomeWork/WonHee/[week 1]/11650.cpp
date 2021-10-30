#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	vector<pair<int,int>> v;

	cin >> n;

	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x>>y;
		v.push_back({ x, y });
	}
	sort(v.begin(), v.end(),compare);

	for (int i = 0; i < n; i++) {
		cout << v[i].first << " " << v[i].second << "\n";
	}

	system("pause");
	return 0;
}
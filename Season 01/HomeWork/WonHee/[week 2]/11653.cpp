#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> v;

int main() {
	cin >> N;
	
	while (N!=1) {
		for (int i = 2; i <= N; i++) {
			if (N%i == 0) {
				v.push_back(i);
				N /= i;
				break;
			}
		}
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		cout << v[i]<<'\n';
	}

	system("pause");
	return 0;
}
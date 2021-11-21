#include <iostream>

using namespace std;

int main() {
	int N;
	int cnt = 0;

	cin >> N;

	for (int i = 7; i >= 0; --i) {
		int res = N >> i & 1;
		if (res == 1)
			cnt++;
	}

	cout << cnt;

	system("pause");
	return 0;
}
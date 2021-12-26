#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int cnt[10001] = { 0, };

	int n;

	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		cnt[a]+=1;
	}

	for (int i = 0; i < 10001; i++) {
		for (int j = 0; j < cnt[i]; j++) {
			cout<<i<<"\n";
		}
	}

	system("pause");
	return 0;
}
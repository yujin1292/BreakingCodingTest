#include <iostream>
#include <vector>
#include<algorithm>

using namespace std;

int N, M;
vector<int> card;
int res=0;

void DFS(int v, int sum, int cnt) {
	if (cnt == 3) {
		if (sum <=M) {
			res = max(res, sum);
			return;
		}
	}
	if (sum > M || v >= N)
		return;
	DFS(v + 1, sum + card[v], cnt + 1);
	DFS(v + 1, sum, cnt);

	return;
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		card.push_back(temp);
	}

	DFS(0,0,0);
	cout << res;

	system("pause");
	return 0;
}
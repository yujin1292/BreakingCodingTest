#include <iostream>
#include <vector>

using namespace std;

vector<int> card;
int N, M, res;

void black(int v, int sum, int cnt) {
	if (sum > M)
		return;

	if (cnt == 3) {
		if (sum > res)
			res = sum;
		return;
	}

	if (v == N)
		return;

	black(v + 1, sum, cnt);
	black(v + 1, sum + card.at(v), cnt + 1);

}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		card.push_back(n);
	}

	black(0, 0, 0);

	cout << res;
	return 0;
}
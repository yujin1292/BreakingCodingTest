#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int> card;
int sum = 0;
int min = 300000;
int res;

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		card.push_back(temp);
	}

	for (int i = 0; i < N - 2; i++) {
		for (int j = i+1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				if (card[i] + card[j] + card[k] <= M && M-(card[i] + card[j] + card[k])<min) {
					min = M - (card[i] + card[j] + card[k]);
					res = card[i] + card[j] + card[k];
				}
			}
		}
	}

	cout << res;

	system("pause");
	return 0;
}
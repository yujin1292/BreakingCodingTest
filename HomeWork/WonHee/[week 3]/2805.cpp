#include <iostream>
#include <algorithm>

using namespace std;

long long N, M;
int tree[1000001];

void binary(int end_h) {
	int start = 0;
	int mid;
	int res=0;
	
	while (end_h >= start) {
		long long sum = 0;
		mid = (start + end_h) / 2;

		for (int i = 0; i < N; i++) {
			if (tree[i] > mid)
				sum += (tree[i] - mid);
		}
		if (sum >= M) {
			if (res < mid)
				res = mid;
			start = mid + 1;
		}
		else
			end_h = mid - 1;
	}
	cout << res;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		tree[i] = temp;
	}

	sort(tree, tree + N);

	binary(tree[N - 1]);
	
	system("pause");
	return 0;
}
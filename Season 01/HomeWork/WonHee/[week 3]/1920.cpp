#include <iostream>
#include <algorithm>

using namespace std;


int N, M;
int A[100001];

void binary(int n) {
	int s = 0;
	int e = N - 1;
	int mid;
	while (e >= s) {
		mid = (s + e) / 2;
		if (A[mid] == n) {
			cout << 1 << "\n";
			return;
		}
		else if (A[mid] > n)
			e = mid - 1;
		else
			s = mid + 1;
	}
	cout << 0 << "\n";
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int temp;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> temp;
		A[i] = temp;
	}

	sort(A, A + N);

	int start = 0;
	int end = N-1;

	cin >> M;

	for (int i = 0; i < M; i++) {
		cin >> temp;
		binary(temp);
	}

	system("pause");
	return 0;
}

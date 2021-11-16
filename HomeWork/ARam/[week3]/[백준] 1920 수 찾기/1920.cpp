#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 100001
using namespace std;

//vector<int> v;
int arr[MAX];

int b_search(int s, int e, int n) {
	if (s == e) {
		if (n == arr[s])
			return 1;
		else
			return 0;
	}

	int m = (s + e) / 2;

	if (n == arr[m])
		return 1;

	if (n > arr[m])
		b_search(m + 1, e, n);

	else
		b_search(s, m - 1, n);
}


int main() {
	int N, M;

	cin >> N;

	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		//v.push_back(n);
		arr[i] = n;
	}

	//sort(v.begin(), v.end());
	sort(arr, arr + N);

	cin >> M;

	for (int i = 0; i < M; i++) {
		int n;
		cin >> n;
		cout << b_search(0, N - 1, n) << "\n";
	}

	return 0;
}
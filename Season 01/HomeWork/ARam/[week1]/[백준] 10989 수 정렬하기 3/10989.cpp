#include <iostream>
#define MAX 10001
using namespace std;

int arr[MAX];


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, num;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> num;
		arr[num]++;
	}

	for (int i = 1; i < MAX; i++) {
		for (int j = 0; j < arr[i]; j++) {
			cout << i << "\n";
		}
	}

	return 0;
}
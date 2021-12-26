#include <iostream>
#include <queue>

using namespace std;

queue<int> q;

int main() {
	int N, K;
	cin >> N >> K;

	for (int i = 1; i < N + 1; i++) {
		q.push(i);
	}

	cout << "<";
	while (!q.empty()) {
		for (int i = 0; i < K - 1; i++) {
			q.push(q.front());
			q.pop();
		}
		if (q.size() == 1)
			cout << q.front();
		else
			cout << q.front() << ", ";
		q.pop();
	}

	cout << ">";

	return 0;
}
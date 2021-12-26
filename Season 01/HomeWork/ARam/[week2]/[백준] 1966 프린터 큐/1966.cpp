#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

queue <pair<int, int> > q;
priority_queue <pair<int, int> >pq;

int printer(int m) {
	int cnt = 1;
	while (!q.empty()) {
		if (q.front().first != pq.top().first) {
			q.push(q.front());
			q.pop();
			continue;
		}
		if (q.front().second == m)
			return cnt;
		q.pop();
		pq.pop();
		cnt++;
	}
}


int main() {
	int T, N, M, p;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> N >> M;
		int max = -1;
		q = queue <pair<int, int> >();
		pq = priority_queue <pair<int, int> >();
		for (int i = 0; i < N; i++) {
			cin >> p;
			q.push(make_pair(p, i));
			pq.push(make_pair(p, i));
		}
		cout << printer(M) << endl;
	}

	return 0;
}
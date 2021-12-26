#include <iostream>
#include <vector>
#include <queue>
#define MAX 101
using namespace std;

int visit[MAX];
vector<int> G[MAX];
queue<pair<int, int> > q;

void calc(int v1, int v2) {
	q.push(make_pair(v1, 0));
	visit[v1] = 1;
	int chonsu = 0;

	while (!q.empty()) {
		//int chonsu = q.front().second;
		int qsize = q.size();
		
		while (qsize--) {
			int cur = q.front().first;
			int size = G[cur].size();

			if (cur == v2) {
				cout << q.front().second << endl;
				return;
			}

			for (int i = 0; i < size; i++) {
				int next = G[cur][i];
				if (visit[next])
					continue;
				q.push(make_pair(next, chonsu + 1));
				visit[next] = 1;
			}
			q.pop();
		}
		chonsu++;
	}
	cout << -1 << endl;
}

int main() {
	int n, v1, v2, m;

	cin >> n >> v1 >> v2 >> m;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		G[x].push_back(y);
		G[y].push_back(x);
	}

	calc(v1, v2);

	return 0;
}
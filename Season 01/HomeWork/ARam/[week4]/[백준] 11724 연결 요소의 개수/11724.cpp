#include <iostream>
#include <vector>
#include <queue>
#define MAX 1001
using namespace std;

vector<int> G[MAX];
queue<int> q;
int visit[MAX];
int N, M;

void bfs(int start) {
	visit[start] = 1;
	q.push(start);

	while (!q.empty()) {
		int cur = q.front();
		int size = G[cur].size();
		q.pop();
		for (int i = 0; i < size; i++) {
			int next = G[cur][i];
			if (visit[next])
				continue;
			bfs(next);
			visit[next] = 1;
		}
	}
}

int count() {
	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		if (visit[i])
			continue;
		bfs(i);
		cnt++;
	}
	return cnt;
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		G[u].push_back(v);
		G[v].push_back(u);
	}

	cout << count();

	return 0;
}
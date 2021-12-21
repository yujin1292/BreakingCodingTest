#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 1001
using namespace std;

int N, M, V;
int visit[MAX];
vector<int> G[MAX];
queue<int> q;

void init() {
	for (int i = 0; i < MAX; i++)
		visit[i] = 0;
}

void sorting() {
	for (int i = 0; i < N; i++) {
		sort(G[i + 1].begin(), G[i + 1].end());
	}
}

void dfs(int start) {
	cout << start << " ";
	visit[start] = 1;
	int size = G[start].size();
	
	for (int i = 0; i < size; i++) {
		int next = G[start][i];
		if (visit[next])
			continue;
		dfs(next);
	}
}

void bfs(int start) {
	q.push(start);
	visit[start] = 1;

	while (!q.empty()) {
		int cur = q.front();
		cout << cur << " ";
		q.pop();
		int size = G[cur].size();
		for (int i = 0; i < size; i++) {
			int next = G[cur][i];
			if (visit[next])
				continue;
			q.push(next);
			visit[next] = 1;
		}
	}
}

int main() {
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int v1, v2;
		cin >> v1 >> v2;
		G[v1].push_back(v2);
		G[v2].push_back(v1);
	}
	sorting();

	dfs(V);
	init();
	cout << endl;
	bfs(V);

	return 0;
}
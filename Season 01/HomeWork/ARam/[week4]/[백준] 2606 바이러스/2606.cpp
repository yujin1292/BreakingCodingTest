#include <iostream>
#include <vector>
#include <queue>
#define MAX 101
using namespace std;

vector<int> G[MAX];
queue<int> q;
int visit[MAX];

void count(int start) {
	q.push(start);
	visit[start] = 1;
	int virus = 0;

	while (!q.empty()) {
		int cur = q.front();
		int size = G[cur].size();
		q.pop();

		for (int i = 0; i < size; i++) {
			int next = G[cur][i];
			if (visit[next])
				continue;
			q.push(next);
			visit[next] = 1;
			virus++;
		}
	}

	cout << virus << endl;
}

int main() {
	int com, connect;
	cin >> com >> connect;

	for (int i = 0; i < connect; i++) {
		int c1, c2;
		cin >> c1 >> c2;
		
		G[c1].push_back(c2);
		G[c2].push_back(c1);
	}

	count(1); // 1번 컴퓨터가 바이러스에 걸렸을 때

	return 0;
}
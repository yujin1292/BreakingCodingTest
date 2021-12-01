#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
#define MAX 101

using namespace std;

int visit[MAX];
vector<int> U[MAX];
vector<pair<int, int> >kevin;
queue<int> q;

void calcKevin(int start) {
	int sum = 0;
	int distance = 0;
	q.push(start);
	visit[start] = 1;

	while (!q.empty()) {
		int qsize = q.size();

		while (qsize--) {
			int cur = q.front();
			int size = U[cur].size();
			for (int i = 0; i < size; i++) {
				int next = U[cur][i];
				if (visit[next])
					continue;
				q.push(next);
				visit[next] = 1;
			}
			sum += distance;
			q.pop();
		}
		distance++;
	}

	kevin.push_back(make_pair(sum, start));
}

int main() {
	int N, M, u1, u2;

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		cin >> u1 >> u2;
		U[u1].push_back(u2);
		U[u2].push_back(u1);
	}

	for (int i = 1; i <= N; i++) {
		calcKevin(i);
		memset(visit, 0, sizeof(visit));
	}

	sort(kevin.begin(), kevin.end());

	cout << kevin.front().second;

	return 0;
}
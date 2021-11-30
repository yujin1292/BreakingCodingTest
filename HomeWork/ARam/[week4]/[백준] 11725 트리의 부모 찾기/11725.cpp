#include <iostream>
#include <vector>
#define MAX 100001
using namespace std;

vector<int> G[MAX];
int visit[MAX];
int parent[MAX];
int N;

void find(int start) {
	int size = G[start].size();
	visit[start] = 1;

	for (int i = 0; i < size; i++) {
		int next = G[start][i];
		if (visit[next])
			continue;
		parent[next] = start;
		find(next);
	}
}

void print() {
	for (int i = 2; i <= N; i++) {
		cout << parent[i] << "\n";
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N-1; i++) {
		int v1, v2;
		cin >> v1 >> v2;

		G[v1].push_back(v2);
		G[v2].push_back(v1);
	}

	find(1);
	print();

	return 0;
}
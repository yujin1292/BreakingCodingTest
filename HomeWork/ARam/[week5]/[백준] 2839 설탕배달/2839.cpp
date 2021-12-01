#include <iostream>

using namespace std;

int N;
int res = -1;

void dfs(int num, int kg) {
	if (kg > N)
		return;

	if (kg == N) {
		res = num;
		return;
	}
	
	dfs(num + 1, kg + 3); // 3kg 선택
	dfs(num + 1, kg + 5); // 5kg 선택	
}

int main() {
	cin >> N;

	dfs(0, 0);

	cout << res;

	return 0;
}
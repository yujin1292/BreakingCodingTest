#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> house;
int N, C;

int install(int m) {
	int front = house.front();
	int c = 1; // 첫 번째 집은 무조건 설치
	for (int i = 1; i < house.size(); i++) {
		if ((house[i] - front) >= m) {
			c++;
			front = house[i];
		}
	}
	return c;
}

int b_search(int s, int e) {
	int mid = (s + e) / 2;
	int ist = install(mid);
	if (s > e)
		return mid;

	if (ist < C)
		return b_search(s, mid - 1);
	else
		return b_search(mid + 1, e);
	
}

int main() {
	cin >> N >> C;
	for (int i = 0; i < N; i++) {
		int h;
		cin >> h;
		house.push_back(h);
	}

	sort(house.begin(), house.end());

	cout << b_search(0, house.back() - house.front());

	return 0;
}
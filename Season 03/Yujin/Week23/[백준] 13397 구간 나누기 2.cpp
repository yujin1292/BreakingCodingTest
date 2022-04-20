#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int> v;

/*

점수를 기준으로 바이너리서치를 진행하겠습니다!..

점수에 따라서, 나뉜 구간의 수를 기준으로 계산했습니당

*/


bool isPossable(int value) {

	int min = v[0];
	int max = v[0];
	int count = 1;

	for (int i = 1; i < N; i++) {

		if (v[i] < min) min = v[i];
		if (v[i] > max) max = v[i];

		int cur = max - min;

		if (cur > value) {
			min = v[i];
			max = v[i];
			count++;
			if (count > M) return false;
		}
	}

	return count <= M; // 나뉜 구간이 M개 이하면 가능한 점수이다!
}


int main() {

	int start = 0;
	int end = -1;
	int min = 50001;

	cin >> N >> M;
	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		v.push_back(num);
		if (end < num) end = num;
		if (min > num) min = num;
	}
	end -= min; // 가능한 점수의 범위를 0 ~ (최댓값-최솟값) 으로 줄임

	int mid;
	while (start <= end) {

		mid = (start + end) / 2;

		if (isPossable(mid)) { // 더 줄여봐.>! 
			end = mid - 1;
		}
		else {
			start = mid + 1;
		}
	}

	cout << start;

	return 0;
}
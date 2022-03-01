#include <iostream>
#include <algorithm>
#include <map>

#define ll long long  // long long이라고 쓰기 귀찮아서 ll 로 치환할수 있도록 선언!

using namespace std;

/*

map 자료 구조 특징

(key,value) 가 한쌍이며,

map[key] = value 와 같이 값을 저장 할 수 있음 (마치 배열같쥬?)

그리고 m.count(key)를 통해서 key(키값)에 해당하는 원소들(value들)의 개수를 반환 받을 수 있습니다
(중복이 없는 구조라 어짜피 0 아니면 1을 반환합니다)

m.count(key) > 0 이면 이미 있는 키값이라는것을 알수있겠죠

*/


/*
이 문제는 stl의 map 자료구조를 이용하여 풀었습니다
미리 계산된 값을 map에 저장하고, 존재하면 가져다쓰고 없으면 재귀형식으로 계산하도록 처리했습니다~~
*/

map<ll, ll> m;
ll P, Q;

ll solve(ll i) {
	if (i == 0) return 1;

	if (m.count(i)>0) return m[i];
	return m[i] = solve(i / P) + solve(i / Q);
}


int main() {
	ll N;
	cin >> N >> P >> Q;

	cout << solve(N);

	return 0;
}




/*
* 일정부분만 메모이제이션
* 질문검색 탭에서 알아냄
* 
#include <iostream>
#include <algorithm>

#define ll long long

using namespace std;

const int MAX = 5000000;
ll dp[MAX];
ll P, Q;

ll solve(ll i) {
	if (i == 0) return 1;

	if (i >= MAX) return  solve(i / P) + solve(i / Q);

	if (dp[i] != -1) return dp[i];


	return dp[i] = solve( i / P) + solve(i / Q);
}

int main() {

	// -1 로 초기화 한다
	fill(dp, dp + MAX, -1);

	ll N;
	cin >> N>> P >> Q;

	cout << solve(N);
	return 0;
}

*/
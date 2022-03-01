#include <iostream>
#include <algorithm>
#include <map>

#define ll long long  // long long�̶�� ���� �����Ƽ� ll �� ġȯ�Ҽ� �ֵ��� ����!

using namespace std;

/*

map �ڷ� ���� Ư¡

(key,value) �� �ѽ��̸�,

map[key] = value �� ���� ���� ���� �� �� ���� (��ġ �迭����?)

�׸��� m.count(key)�� ���ؼ� key(Ű��)�� �ش��ϴ� ���ҵ�(value��)�� ������ ��ȯ ���� �� �ֽ��ϴ�
(�ߺ��� ���� ������ ��¥�� 0 �ƴϸ� 1�� ��ȯ�մϴ�)

m.count(key) > 0 �̸� �̹� �ִ� Ű���̶�°��� �˼��ְ���

*/


/*
�� ������ stl�� map �ڷᱸ���� �̿��Ͽ� Ǯ�����ϴ�
�̸� ���� ���� map�� �����ϰ�, �����ϸ� �����پ��� ������ ����������� ����ϵ��� ó���߽��ϴ�~~
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
* �����κи� �޸������̼�
* �����˻� �ǿ��� �˾Ƴ�
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

	// -1 �� �ʱ�ȭ �Ѵ�
	fill(dp, dp + MAX, -1);

	ll N;
	cin >> N>> P >> Q;

	cout << solve(N);
	return 0;
}

*/
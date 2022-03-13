#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// pair의 두번째 인자를 기준으로 정렬하기 위해 생성한 비교함수
bool cmp(pair<int, int> a, pair<int, int > b) {
	return a.second < b.second;
}


/*
*
* input : 2 4 -10 4 -9
* 
* 입력값을  { ( pos ,idx ),  ...} 형태로 저장
* v = { (2,0), (4,1), (-10,2), (4,3), (-9,4) }
*
* step 1 : 압축할 좌표를 기준으로 정렬 ( pair 의 first )
* v = { (-10, 2 ), (-9,4) , (2,0), (4,1), (4,3) }
* 
* step 2 : 숫자를 단순화 한다
* v = { (0, 2 ), (1,4) , (2,0), (3,1), (3,3) }
*
* 
* step 3: 다시 인덱스를 기준으로 정렬한다
* v = { (2,0), (3,1),   (0, 2 ),  (3,3), (1,4)  }
*
* step 4:  답 출력 
*  2 3 0 3 1
*
*/


int main() {
	// 빠른 입출력을 위한 코드
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<pair<int, int> > v;


	int N, temp;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		v.push_back({temp, i});
	}

	// step 1
	sort(v.begin(), v.end()); 


	// step 2
	int last =  -1;
	int count = -1;
	for (int i = 0; i < N; i++) {
		if (last != v[i].first)
			count++;
		last = v[i].first;
		v[i].first = count;
	}


	// step 3
	sort(v.begin(), v.end(), cmp); 

	// step 4
	for (int i = 0; i < N; i++) {
		cout << v[i].first << " " ;
	}

	return 0;
}
# 백준 10989
## KEYWORD : 시간 복잡도, counting sort
## POINT : N의 범위가 1000만까지 가능, 시간복잡도는 O(N), O(N+k)
## TIP : 입력값이 10000개까지 가능하기 때문에 미리 리스트를 만듦

import sys

# 1. 전체 수 N 입력 받기
n = int(sys.stdin.readline())
n_list = [0] * 10001

# 2. N만큼의 숫자 받기
for _ in range(n):
    num = sys.stdin.readline()
    n_list[int(num)] += 1

# 3. 결과 출력
for i in range(10001):
    if n_list[i] != 0:
        for j in range(n_list[i]):
            print(i)
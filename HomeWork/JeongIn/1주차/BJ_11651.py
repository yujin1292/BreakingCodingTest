# 백준 11651
## KEYWORD : 시간 복잡도,
## POINT : arr에 추가하는 순서를 바꿔서 올바르게 출력되도록 만듦
## TIP :

import sys
n = int(sys.stdin.readline())

arr = []

# 1. 리스트에 좌표 입력
for _ in range(n):
    x,y = map(int, sys.stdin.readline().split())
    arr.append([y,x])

# 2. 좌표 정렬
## lambda를 이용한 방법도 참고
## arr.sort(key=lambda x:(x[1], x[0]))
sorted_arr = sorted(arr)

for y, x in sorted_arr:
    print(x,y)
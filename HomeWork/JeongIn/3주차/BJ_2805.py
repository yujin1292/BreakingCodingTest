#PyPy3으로 제출해야 정답 인정
# 273288KB, 560ms
import sys

# 1. 나무의 수 N, 집으로 가져가려는 나무 길이 M
N, M = map(int, sys.stdin.readline().split())
# 각 나무의 높이
hight = list(map(int, input().split()))

start, end = 0, max(hight)
max_hight = 0

# 이분 탐색
while start <= end :
    mid = (start+end)//2
    total_hight = 0
    for i in range(N):
        if mid < hight[i]:
            total_hight += hight[i] - mid

    if total_hight >= M :
        # 총 얻은 나무 길이가 원하는 나무 길이보다 많거나 같다면 더 위에서 잘라도 됨
        start = mid + 1
        max_hight = mid
    else:
        # 총 얻은 나무 길이가 원하는 나무 길이보다 모자르다면 더 아래에서 잘라야 함
        end = mid - 1

# 2. 설정할 수 있는 높이의 최댓값 출력
print(max_hight)
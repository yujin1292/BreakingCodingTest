# 완전탐색
# 29200KB, 100ms
import sys

# 1. 카드의 개수 N, M
N, M = map(int, sys.stdin.readline().split())
num = list(map(int, input().split()))
max_sum = 0

# 2. M보다 작은 3개 숫자합의 최대값
for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range (j+1, N):
            if max_sum <= num[i]+num[j]+num[k] <= M:
                max_sum = num[i]+num[j]+num[k]

# 3. 출력
print(max_sum)
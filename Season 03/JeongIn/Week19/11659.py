# 11659 구간 합 구하기

import sys

input = sys.stdin.readline

N, M = map(int, input().split()) # 수의 개수와 합을 구해야 하는 횟수

nums = []
nums_sum = [0] # 미리 증가하는 방향의 총합을 더해 저장해놓음 # 처음에는 아무 숫자도 더해지지 않으므로 0으로 초기화
cur_total_sum = 0

nums = list(map(int, input().split())) # 공백으로 입력받기

for num in nums:
    cur_total_sum += num
    nums_sum.append(cur_total_sum)

for _ in range(M):
    min_range, max_range = map(int,input().split())
    print(nums_sum[max_range] - nums_sum[min_range - 1])

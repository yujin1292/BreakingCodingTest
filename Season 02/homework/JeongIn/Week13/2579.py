# 1. 계단은 1/2 칸씩 오르기 가능
# 2. 연속된 세 개의 계단을 모두 밟으면 안됨 (시작점 포함 x) = i, i+1 계단 밟았다면 반드시 건너뛰어야 함
# 3. 마지막 계단은 반드시 밟아야 함

# 얻을 수 있는 점수의 최댓값

import sys

input = sys.stdin.readline # 시간 줄이기 위한 코드

n = int(input()) # 계단의 수
stairs = []
dp = []

for i in range(n):
    stairs.append(int(input())) # 각 계단의 비용

if n == 1:
    print(stairs[0]) # 계단이 한 개일 경우 그 계단만 밟음

elif n == 2:
    print(stairs[0] + stairs[1]) # 계단이 두 개일 경우 두 계단을 모두 밟음

else:
    dp.append(stairs[0]) # 첫 번째 계단 값
    dp.append(stairs[0]+stairs[1]) # 두 번째 계단까지의 값
    dp.append(max(dp[0]+stairs[2], stairs[1]+stairs[2])) # 첫 계단 -> 세번째 계단인 경우, 두번째 계단 -> 세번째 계단인 경우 중 최댓값
    for i in range(3, n):
        dp.append(max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]))
    print(dp[-1]) # 0부터 시작했으므로 마지막 값 출력


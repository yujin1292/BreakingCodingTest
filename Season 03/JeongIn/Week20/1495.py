# 기타리스트
import sys
input = sys.stdin.readline

N, S, M = map(int, input().split()) # 곡의 개수, 시작 볼륨, 최대 볼륨
V = list(map(int, input().split())) # 각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이

dp = [[False] * (M+1) for _ in range(N+1)]
dp[0][S] = True # 시작 볼륨 가능

for i in range(N):
    for j in range(M + 1):
        check = dp[i][j] # 시간 단축을 위해 dp에 인덱스로 볼륨 정보를 저장(가능한지, 아닌지)
        if check:
            if j + V[i] <= M:
                dp[i+1][j + V[i]] = True # 볼륨 키우기 가능
            if j - V[i] >= 0:
                dp[i+1][j - V[i]] = True # 볼륨 줄이기 가능

result = -1

for i in range(M + 1):
    if dp[N][i]:
        result = i

print(result)



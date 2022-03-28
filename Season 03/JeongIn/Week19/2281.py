# 2281 데스노트
# DP(메모이제이션)

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
# INF = (999 ** 2) * 999 # 최악의 경우 999칸씩 999번 비게 됨
INF = 10 ** 9 # 위 경우보다 메모리 4KB 더 차지하지만 4ms 단축

n, m = map(int, input().split()) # n : 사람 수 , m : 노트 가로 칸 수(폭)
names_len = [] # 이름 글자수 저장하는 리스트
dp = [[-1] * m for _ in range(n)] # dp[i][j] 는 i번째 사람 이름을 썼을 때 총 칸수 제곱의 합


for _ in range(n):
    names_len.append(int(input()))

def write_name(next_idx, remain):

    if next_idx == n :
        return 0

    # 아직 써야할 사람이 남아있는 경우
    if dp[next_idx][remain] < 0 :
        next_len = names_len[next_idx]
        ans = INF

        if next_len < remain :
            ans = min(ans, write_name(next_idx+1, remain - names_len[next_idx] - 1)) # 현재 줄에 쓸 수 있는 경우

        ans = min(ans, write_name(next_idx+1, m - names_len[next_idx]) + remain **2 ) # 다음 줄로 넘겨쓸 경우
        dp[next_idx][remain] = ans

    return dp[next_idx][remain]

print(write_name(1, m-names_len[0]))
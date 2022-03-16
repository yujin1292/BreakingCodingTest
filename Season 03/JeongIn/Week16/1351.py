import sys

input = sys.stdin.readline

# 입력 : 3개의 정수
N, P, Q = map(int, input().split())
ans = {} # 계산 값을 저장할 딕셔너리, 일반 배열로 할 경우 시간초과

def dfs(n):
    global P, Q, ans
    if n < 1:
        return 1

    elif n in ans:
        return ans[n]

    ans[n] = dfs(n // P) + dfs(n // Q)
    return ans[n]


print(dfs(N))
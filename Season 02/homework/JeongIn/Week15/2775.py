# DP


import sys

input = sys.stdin.readline

T = int(input()) # Test case

for i in range(T):
    k = int(input()) # k층에
    n = int(input()) # n호에 몇 명이 사는 지 출력

    floor = [i for i in range(1, n+1)] # 0층의 n호까지 사는 사람들을 미리 구해 놓음

    # 0층의 i호에는 i명이 살고 있음
    for _ in range(k):
        for i in range(1, n):
            floor[i] += floor[i-1] # k층 n호에 사려면 i-1층의 1호부터 n까지 사람들의 수의 합만큼 데려와 살아야 함
    print(floor[-1])
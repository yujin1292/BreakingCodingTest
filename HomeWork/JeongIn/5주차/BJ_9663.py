# N-Queen


import sys


N = int(sys.stdin.readline())
# Queen 을 놓으면 그 Row에는 더 이상 Queen 을 놓을 수 없으므로 col에 대한 경우만 봐줌
col = [False] * N
rr = [False] * 2 * N
ll = [False] * 2 * N
ans = 0


def dfs(x):
    global ans

    next_x = x+1

    if (next_x == N):
        ans += 1
        return


    for j in range(N):
        if (rr[next_x + j]==False) and (ll[N + next_x - j]==False) and (col[j]==False):
            col[j] = rr[next_x+j] = ll[N+next_x-j] = True
            dfs(next_x)
            col[j] = rr[next_x+j] = ll[N+next_x-j] = False # 다음 j 경우에서 다른 경우도 탐색해보아야 하므로 False로 다시 바꿔줌





dfs(-1)
print(ans)


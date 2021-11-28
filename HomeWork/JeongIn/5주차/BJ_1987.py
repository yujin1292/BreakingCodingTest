# 시간초과가 나는 이유
import sys
sys.setrecursionlimit(10000) # 시간초과 방지용

dx = [1,-1,0,0]
dy = [0,0,1,-1]
ans = 1 # 최소 한 칸

R, C = map(int, sys.stdin.readline().split())

# 참고 : 아스키코드를 이용하여 영자를 숫자로 변환하여 관리
board = [list(map(lambda x: ord(x) - 65, input().rstrip())) for _ in range(R)]
visited = [0] * 26
visited[board[0][0]] = 1

def dfs(x, y, result):
    global ans

    ans = max(ans, result)

    # 좌우상하 확인
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        # index 와 새로운 칸 중복 체크
        if 0 <= nx < R and 0 <= ny < C and visited[board[nx][ny]] == 0:
            visited[board[nx][ny]] = 1
            dfs(nx, ny, result + 1)
            visited[board[nx][ny]] = 0

dfs(0,0,ans)
print(ans)
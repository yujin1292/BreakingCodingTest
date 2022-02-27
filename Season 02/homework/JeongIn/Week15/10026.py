# 적록색약
# BFS

# 입력 N*N 그리드

# 출력 적록색약 아닌 사람이 밨을 때 구역의 개수와 적록색약인 사람이 봤을 때 구역의 수 공백으로 구분 후 출력
# 적록색약인 사람은 빨강 / 초록의 차이를 구분하지 못함


import sys
from collections import deque

input = sys.stdin.readline

N = int(input()) # 그리드의 크기
rgb_board = [list(map(str, input())) for _ in range(N)] # RGB로 이루어진 그리드 입력 받기
gb_board = [[''] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if rgb_board[i][j] == 'R':
            gb_board[i][j] = 'G'
        else:
            gb_board[i][j] = rgb_board[i][j]
rgb_visited = [[False] * N for _ in range(N)]
gb_visited = [[False] * N for _ in range(N)]

rgb_cnt = 0
gb_cnt = 0


dx = [-1, 1, 0, 0] # 좌, 우
dy = [0, 0, -1, 1] # 하, 상

def bfs(x, y, board, visited):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue :
        x, y = queue.popleft()

        for i in range(4):
            # 상, 하, 좌, 우를 살피며 쓰레기 검사
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<= nx <N and 0 <= ny < N:
                if board[nx][ny] == board[x][y] and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

for i in range(N):
    for j in range(N):
        if not rgb_visited[i][j] :
            bfs(i,j,rgb_board, rgb_visited)
            rgb_cnt+=1
        if not gb_visited[i][j] :
            bfs(i,j, gb_board, gb_visited)
            gb_cnt+=1

print(f"{rgb_cnt} {gb_cnt}")

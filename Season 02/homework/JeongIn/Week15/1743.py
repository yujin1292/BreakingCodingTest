# BFS

import sys
from collections import deque

input = sys.stdin.readline

N, M, K = map(int, input().split()) # 통로의 세로 길이, 가로길이, 음식물 쓰레기의 개수

# 통로
board = [[0] * M for _ in range(N)]

# 방문체크
visited = [[False] * M for _ in range(N)]

# 쓰레기 위치 입력
for _ in range(K):
    r, c  = map(int, input().split())
    board[r-1][c-1] = 1

dx = [-1, 1, 0, 0] # 좌, 우
dy = [0, 0, -1, 1] # 하, 상

queue = []


def bfs(x, y):
    cnt = 0
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue :
        x, y = queue.popleft()

        for i in range(4):
            # 상, 하, 좌, 우를 살피며 쓰레기 검사
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<= nx <N and 0 <= ny < M:
                if board[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    cnt += 1

    return cnt + 1

# 음식물 중 가장 큰 음식물의 크기를 출력
max_food =0
for i in range(N):
    for j in range(M):
        if board[i][j] == 1 and not visited[i][j]:
            max_food = max(max_food, bfs(i, j))

print(max_food)




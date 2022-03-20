import sys
from collections import *

# input = sys.stdin.readline


N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
visited = [[[[False] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
rx, ry, bx, by = 0, 0, 0, 0


for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            rx, ry = i, j # 빨간 구슬의 위치
        elif board[i][j] == 'B':
            bx, by = i, j # 파란 구슬의 위치
# # : 공이 이동할 수 없는 장애물, 벽
# 0 : 구멍의 위치
# . : 빈 칸

def move(x, y, dx, dy):
    count = 0
    while board[x+dx][y+dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count

def bfs(rx, ry, bx, by):

    q = deque()
    # 빨간 구슬, 파란 구슬 위치와 depth 추가
    q.append((rx, ry, bx, by, 1))
    visited[rx][ry][bx][by] = True


    while q:
        rx_now, ry_now, bx_now, by_now, depth = q.popleft() # 현재 구슬의 위치, 깊이
        if depth > 10 :
            break # 종료조건 : 10번 안에 구슬을 빼낼 수 없는 경우

        for i in range(4):
            # 구슬이 벽에 부딪히거나 구멍에 도달했을 시
            rx_next, ry_next, r_cnt = move(rx_now, ry_now, dx[i], dy[i])
            bx_next, by_next, b_cnt = move(bx_now, by_now, dx[i], dy[i])

            # 파란 구슬 말고 빨간 구슬만 구멍에 빠진 경우
            if board[bx_next][by_next] != 'O' and board[rx_next][ry_next] == 'O':
                return depth

            # 불가 : 빨간 구슬과 파란 구슬이 같은 칸에 있는 경우
            if rx_next == bx_next and ry_next == by_next :
                # 파란 구슬이 선점한 경우 빨간 구슬 일보 후퇴
                if r_cnt > b_cnt:
                    rx_next -= dx[i]
                    ry_next -= dy[i]

                else:
                    bx_next -= dx[i]
                    by_next -= dy[i]

                if not visited[rx_next][ry_next][bx_next][by_next]:
                    visited[rx_next][ry_next][bx_next][by_next] = True
                    q.append((rx_next, ry_next, bx_next, by_next, depth+1))

    return -1

print(rx, ry, bx, by)

print(bfs(rx, ry, bx, by))
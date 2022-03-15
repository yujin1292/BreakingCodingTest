from collections import deque

N, M = map(int, input().split())
graph = [list(input()) for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
rx, ry, bx, by = 0, 0, 0, 0
visited = [[[[False] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]

for i in range(N):
    for j in range(M):
        if graph[i][j] == 'R':
            rx, ry = i, j # 빨간 구슬의 위치
        elif graph[i][j] == 'B':
            bx, by = i, j # 파란 구슬의 위치

def move(x, y, dx, dy):
    count = 0
    while graph[x+dx][y+dy] != '#' and graph[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count

def bfs(rx, ry, bx, by):
    q = deque()
    q.append((rx, ry, bx, by, 1))
    visited[rx][ry][bx][by] = True
    while q:
        rx_now, ry_now, bx_now, by_now, depth = q.popleft()
        if depth > 10:
            break
        for i in range(4):
            rx_next, ry_next, r_cnt = move(rx_now, ry_now, dx[i], dy[i])
            bx_next, by_next, b_cnt = move(bx_now, by_now, dx[i], dy[i])
            if graph[bx_next][by_next] != 'O':
                if graph[rx_next][ry_next] == 'O':
                    return depth
                # 불가 : 빨간 구슬과 파란 구슬이 같은 칸에 있는 경우
                if rx_next == bx_next and ry_next == by_next:
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


print(bfs(rx, ry, bx, by))
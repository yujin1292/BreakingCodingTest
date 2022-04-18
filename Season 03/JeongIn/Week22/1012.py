# 유기농 배추

import sys
# bfs
from collections import deque

input = sys.stdin.readline

# 테스트 케이스 개수
T = int(input())
# 상화좌우 확인
dx = [0,0,1,-1]
dy = [1,-1,0,0]


def bfs(loc, nloc):
    queue = deque()
    queue.append((loc, nloc))
    cabbage_loc[loc][nloc] = 2 # 방문 표시를 2로 해줌

    while queue:
        x, y = queue.popleft()

        for direct in range(4):
            nx = x + dx[direct]
            ny = y + dy[direct]

            if 0 <= nx < N and 0 <= ny < M and cabbage_loc[nx][ny] == 1 :
                cabbage_loc[nx][ny] = 2
                queue.append((nx, ny))

            else:
                continue


    return




for _ in range(T):
    # 필요한 배추 흰지렁이 수
    need_num = 0
    # 배추밭 가로길이, 세로길이, 배추 심어진 위치 수
    N, M, K = map(int, input().split())
    cabbage_loc = [[0] * M for _ in range(N)]

    # 배추 있는 위치 표시
    for _ in range(K):
        loc, nloc = map(int, input().split())
        cabbage_loc[loc][nloc] = 1

    for x in range(N):
        for y in range(M):
            if cabbage_loc[x][y] == 1:
                bfs(x, y) # 연결된 배추 한 영역으로 취급
                need_num += 1 # count

    print(need_num)



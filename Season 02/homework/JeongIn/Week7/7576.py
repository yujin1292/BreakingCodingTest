# 최단 거리를 계산하는 문제 -> BFS 로 접근
from collections import deque

# 범위 및 토마토 정보 입력
M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]
riped = deque()
date = 0 # 질문! date를 -1로 설정하면 왜 "틀렸습니다"가 나오는 걸까요?

for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            riped.append((i,j)) # 익은 토마토가 존재하는 위치 추가


def bfs():
    # 이동할 방향을 미리 정의®
    dx = [-1, 1, 0, 0] # 좌우
    dy = [0, 0, -1, 1] # 하상

    # 이동한 현재 위치에서 상,하,좌,우를 탐색하며 이동 가능한 지점을 찾음
    while riped:
        x, y = riped.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >=N or ny < 0 or ny >=M: # 토마토가 없는 경우
                continue

            if box[nx][ny] == 0: # 안익은 토마토인 경우
                box[nx][ny] = box[x][y] + 1 # 최단 거리 저장을 위한 갱신
                riped.append((nx, ny)) # 이제 익었으므로 위치 삽입

    # 토마토가 가능한만큼 익은 후 box 반환
    return box

bfs()


for i in range(N):
    for j in range(M):
        if box[i][j] == 0:
            print(-1)
            exit(0) # 프로그램 종료

        date = max(date, box[i][j]) # 저장되어 있는 최대 값이 토마토가 마지막으로 익은 날짜이므로 max값 필요

print(date-1)
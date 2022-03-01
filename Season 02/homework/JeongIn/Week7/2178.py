# 최단 거리를 계산하는 문제 -> BFS 로 접근


from collections import deque
import sys

# 범위 및 미로 입력
N, M = map(int, input().split())
board = [list(map(int, list(input().strip()))) for _ in range(N)]

# for _ in range(N):
#   board.append(list(map(int, input())))


def bfs(x, y):
    # 이동할 방향을 미리 정의
    dx = [-1, 1, 0, 0] # 좌우
    dy = [0, 0, -1, 1] # 하상

    # 방문 기록할 큐 생성
    visited = deque()
    visited.append((x,y)) # 현재 위치 추가

    # 이동한 현재 위치에서 상,하,좌,우를 탐색하며 이동 가능한 지점을 찾음
    while visited:
        x, y = visited.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >=N or ny < 0 or ny >=M: # 벽을 넘어가는 경우
                continue

            if board[nx][ny] == 0: # 벽인 경우
                continue

            # 경로가 존재하는 경우 방문 기록
            if board[nx][ny] == 1:
                board[nx][ny] = board[x][y] + 1 # 위치를 옮겼기 때문에 count 된 값을 저장
                visited.append((nx, ny))

    # 최종 지점에 저장된 거리값 반환
    return board[N-1][M-1]

print(bfs(0,0)) # 첫번째 위치를 넣어 코드 시작
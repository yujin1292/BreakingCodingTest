
import sys
from collections import deque

input = sys.stdin.readline

N, L, R = map(int, input().split()) # 땅 크기, 인구차이 최소, 인구차이 최대

graph = [list(map(int, input().split())) for _ in range(N)] # 땅크기만큼 각 나라의 인구수

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

is_move = False # 인구이동이 일어났는지 체크


def bfs(cx, cy, visited, grpah):
    global is_move

    people = graph[cx][cy]
    count = 1
    q = deque()
    q.append((cx, cy))
    visited[cx][cy] = True
    temp = list()
    temp.append((cx, cy))

    while q:
        pop_x, pop_y = q.popleft()

        for i in range(4):
            next_x = pop_x + dx[i]
            next_y = pop_y + dy[i]

            if next_x < 0 or next_x >= N or next_y < 0 or next_y >= N:
                continue

            if visited[next_x][next_y]:
                continue

            # 인구 수 차이가 정해진 범위를 만족할 때
            if L <= abs(grpah[pop_x][pop_y] - grpah[next_x][next_y]) <= R:
                visited[next_x][next_y] = True # 방문처리
                q.append((next_x, next_y))
                people += graph[next_x][next_y]
                count += 1
                temp.append((next_x, next_y)) # 연합될 노드들 추가

    move_people = people // count # 연합을 이루고 있는 각 칸의 인구수

    if count > 1:
        is_move = True
        for x, y in temp:
            graph[x][y] = move_people

answer = 0

while True:
    # 인구이동이 발생하지 않을 때까지 while True
    is_move = False # 인구 이동 유무
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            # 아직 방문 전이면 해당 노드를 시작으로 bfs 호출
            if not visited[i][j]:
                bfs(i, j, visited, graph)

    if is_move:
        answer += 1
    else:
        break

print(answer)
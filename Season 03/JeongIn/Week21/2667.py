# 2667 단지 번호 붙이기

import sys

# input = sys.stdin.readline

# 지도의 크기
N = int(input())
maps = [[0] * N for _ in range(N)]
visited = [[False] * N for _ in range(N)]

for i in range(N):
    line = input()
    for j , house in enumerate(line):
        maps[i][j] = int(house)

dx = [0,0,-1,1]
dy = [1,-1,0,0]

# dfs
def dfs(x , y):
    global cnt
    visited[x][y] = True

    if maps[x][y] == 1:
        cnt += 1 # 새로운 집 발견 시 갯수 늘림

    for i in range(4):
        nx = x + dx[i] # next x
        ny = y + dy[i] # next y

        # 범위 내이고
        if 0 <= nx < N and 0 <= ny < N:
            # 방문하지 않았으며, 집이 있을 경우
            if visited[nx][ny] == False and maps[nx][ny] == 1:
                dfs(nx, ny) # 계속 갯수 셈
cnt = 0
house_cnts = []

# 지도의 모든 부분을 순회하며 count 진행
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1 and visited[i][j] == False:
            dfs(i,j)
            house_cnts.append(cnt)
            cnt = 0

house_cnts.sort() # 오름차순 정렬
print(len(house_cnts))
for each_house_cnt in house_cnts:
    print(each_house_cnt)
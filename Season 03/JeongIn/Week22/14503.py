# 로봇 청소기

import sys
sys.setrecursionlimit(100000) # 재귀 사용하는 경우 무조건 추가
input = sys.stdin.readline

# 세로 크기, 가로크기
N, M = map(int, input().split())

# 로봇청소기가 있는 좌표와 방향(0 북 1 동 2 남 3 서)
x, y, direction = map(int, input().split())

# 현재위치 청소했으므로 청소한 칸 갯수는 1
clean_num = 1

dx = [-1,0,1,0] # row
dy = [0,1,0,-1] # column

place = []
# 공간 입력
for _ in range(N):
    place.append(list(map(int, input().split())))

# 로봇청소기가 방문한경우 2로 표시
place[x][y] = 2


# 청소기 회전
def turn_left(d):
    return (d+3)%4

def turn_back(d):
    return (d+2)%4

def clean_place(x, y, depth):
    global direction, clean_num
    # 네 방향 모두 회전한 경우
    if depth == 4:
        # 후진 위치 계산
        nx = x + dx[turn_back(direction)]
        ny = y + dy[turn_back(direction)]

        # 이미 청소된 경우
        if place[nx][ny] == 2:
            clean_place(nx,ny,0) # 빈공간이나 벽이 나올때까지 후진

        # 벽인경우
        else:
            # 작동 멈춤
            print(clean_num)
            exit(0)


    # 방향 전환
    direction = turn_left(direction)
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 청소를 하지 않았다면
    if place[nx][ny] == 0 :

        # 청소 표시
        place[nx][ny] = 2 # 청소 표시
        clean_num += 1 # 청소 칸 표시
        # 다음 칸 청소
        clean_place(nx,ny,0)

    # 청소를 했거나 벽이라면
    else:
        # elif place[nx][ny] == 1 or place[nx][ny] == 2:
        clean_place(x, y, depth+1)


clean_place(x,y,0)
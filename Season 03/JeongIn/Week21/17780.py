# 17780 새로운 게임
# 시뮬레이션은 너무너무 어려워

import sys


input = sys.stdin.readline



def move(chess_num):
    x, y, z = chess[chess_num] # 움직일 체스말의 정보 반환

    # 해당 말이 다른 말에 올려져있는 경우 return(함께 움직이므로 움직일 필요 없음)
    if chess_num != chess_stack[x][y][0]:
        return 0

    nx = x + dx[z] # next x
    ny = y + dy[z] # next y

    # 파란색 칸인 경우
    if not 0 <= nx < N or not 0 <= ny < N or chess_map[nx][ny] == 2:
        if 0 <= z <= 1:
            nz = (z+1) % 2
        else:
            nz = (z-1) % 2 + 2

        # 방향 바꿈
        chess[chess_num][2] = nz
        nx = x + dx[nz]
        ny = y + dy[nz]

        # 바꿔서 이동하려는 칸이 파란색 판인 경우
        if not 0 <= nx < N or not 0 <= ny < N or chess_map[nx][ny] == 2:
            return 0

    chess_set = [] # 이동할 체스 묶음
    chess_set.extend(chess_stack[x][y])
    chess_stack[x][y] = [] # 해당 좌표 초기화

    if chess_map[nx][ny] == 1:
        chess_set = chess_set[-1::-1]


    for i in chess_set:
        chess_stack[nx][ny].append(i) # 다음 위치에 쌓인 체스말 정보 입력
        chess[i][:2] = [nx, ny] # 체스말 위치 정보 갱신

    # 4개의 말이 모두 쌓인 경우 1을 return
    if len(chess_stack[nx][ny]) >= 4:
        return 1
    return 0


## 입력 관련
N, K = map(int, input().split()) # N : 체스판의 크기, K : 말의 개수

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

chess_map = [list(map(int, input().split())) for _ in range(N)] # 체스판 정보
chess_stack = [[[] for _ in range(N)] for _ in range(N)] #
chess = [0 for _ in range(K)]


for i in range(K):
    x, y, z = map(int, input().split()) # 행, 열, 이동방향
    chess_stack[x - 1][y - 1].append(i)
    chess[i] = [x-1, y-1, z-1] # 현재 체스말의 위치(행,열)와 이동방향


## 실제 연산
cnt = 1
while cnt <= 1000:
    # 체스 말 숫자만큼 반복
    for i in range(K):
        flag = move(i)
        if flag:
            print(cnt)
            sys.exit()
    # 아직 이동중이라면 cnt 증가 후 이동 반복
    cnt += 1
print(-1)
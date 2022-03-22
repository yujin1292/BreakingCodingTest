import sys

# 입 출력도 맞게 나오고 파이참 프로그램 상에선 런타임 에러가 없는데 백준에서는 런타임 에러가 나오는 이유가 뭘까요?

input = sys.stdin.readline

N = int(input()) # 홀수 자연수
target = int(input()) # 위치를 찾고자 하는 자연수

dx = [0,1,0,-1]
dy = [1,0,-1,0]

board = [[0] * N for _ in range(N)] # N*N 사이즈의 맵 생성
now_dir = 0 # 현재 진행방향 의미
now_num = N * N # 가장 밖에서부터 돔
cx, cy = 0, 0 # current x, y -> 왼쪽 위, 즉 0,0

# 달팽이 시작에 도달할 때 까지
while now_num > 1:
    if now_num == target or target == 1:
        target_x , target_y = cx+1, cy+1 # 출력 시 1,1부터 시작하는 좌표계로 인식하므로 1을 더함

    board[cy][cx] = now_num  # 현재 위치에 현재 값을 채움
    nx = cx + dx[now_dir] # 다음 위치 후보
    ny = cy + dy[now_dir] # 다음 위치 후보

    if 0 <= nx < N and 0<= ny < N and board[ny][nx] == 0:
        # 다음 위치 후보가 범위 내이고, 아직 가지 않은 "0" 값이라면
        cx, cy = nx, ny
        now_num -=1
    else:
        now_dir = (now_dir + 1) % 4 # 방향을 바꿔줌

board[cy][cx] = now_num # 마지막 1을 넣어줌

for row in board:
    print(*row)

print(target_y, target_x)
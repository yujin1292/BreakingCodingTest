import sys
input = sys.stdin.readline
N = int(input())
target = int(input()) # 위치를 찾고자 하는 자연수

dx = [0,1,0,-1]
dy = [1,0,-1,0]

board = [[0] * N for _ in range(N)] # N*N 사이즈의 맵 생성
move = 0 # 특정 방향으로 얼마나 이동할 것인가
now_num = 1 # 시작 숫자
cx, cy = (N-1)//2, (N-1)//2 # current x, y -> 왼쪽 위, 즉 0,0

board[cx][cy] = now_num

while True:
    for direction in range(4):
        for _ in range(move):

            if now_num == target:
                target_x , target_y = cx+1, cy+1 # 출력 시 1,1부터 시작하는 좌표계로 인식하므로 1을 더함

            cx+=dx[direction]
            cy+=dy[direction]

            now_num += 1

            board[cx][cy] = now_num

    if cx == cy == 0:
        break

    # 한번 돌린 후 새로운 시작점 셋팅
    cx -= 1
    cy -= 1
    move += 2

for row in board:
    print(*row)

print(target_y, target_x)
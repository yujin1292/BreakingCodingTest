# 2032 극장 좌석
# 완전탐색으로 푸려다가 낭패볼 뻔!

import sys

input = sys.stdin.readline

# 좌석의 개수
N = int(input())

# 고정석의 개수
M = int(input())

# 1. 자신의 횐쪽, 오른쪽 좌석으로는 자리 옮길 수 있음
# 2. VIP 인 경우 자기 좌석에만 앉을 수 있음
# 3. VIP 좌석 주어졌을 때 다른 사람들이 옮겨서 앉을 수 있는 방법은?

vips = []
for _ in range(M):
    vips.append(int(input()))
# vip 경우를 배제하고 생각한다면(vip=0일 때)
# 좌석이 두 개인 경우 12 / 21 로 두 가지 방법이 생김
# 좌석 수 : 경우의 수
# 0 : 1
# 1 : 1
# 2 : 2
# 3 : 3
# 4 : 5
seat_cnt = [1,1,2] # 자리 배정 경우의 수

for seat_num in range(3, N+1):
    seat_cnt.append(seat_cnt[seat_num - 1] + seat_cnt[seat_num -2])

cnt = 1 # vip 포함 경우의 수

# vip 가 1명 이상인 경우만 연산 진행
if M >= 1:

    pre_vip_seat_num = 0

    for i in range(0, M):
        # vip 좌석 전까지 좌석 수에 대해 경우의 수를 고려(합 경우의 수에 곱함 - 동시 발생이므로)
        cnt = cnt * seat_cnt[vips[i] - 1 - pre_vip_seat_num]

        # 이전 vip 좌석 번호를 차후 빼줘야 vip 석 사이 좌석 갯수를 고려할 수 있음음
        pre_vip_seat_num = vips[i]

    cnt = cnt * seat_cnt[N - pre_vip_seat_num]

else:
    cnt = seat_cnt[N]

print(cnt)
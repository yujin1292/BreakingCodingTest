# 이분탐색으로 풀어주세여
# 젤 어려웠던 문제 ..!
# 33052KB, 364ms

import sys

# 1. 집의 수 N, 공유기 수 C
N, C = map(int, sys.stdin.readline().split())
houses = []
for _ in range(N):
    houses.append(int(sys.stdin.readline()))

houses.sort()

# 2. 이분탐색(가장 인접한 두 공유기 사이 최대 거리 출력)
def binary_search(house, N, C):
    start = 1 # 최소 좌표값
    end = house[-1]-house[0] # 가장 먼 두 거리
    result = 0

    while start<=end:
        mid = (start+end)//2 # 맨 처음 놓아지는 공유기는 양 끝의 가운데 지점
        current = house[0] # 공유기를 놓은 위치
        count = 1 # 현재까지 설치한 공유기

        for i in range(1, N):
            if house[i] >= current + mid:
                # 앞집부터 최대 넓이로 공유기 설치해나감
                count += 1
                current = house[i] # current = 현재 공유기 설치된 집 위치

        if  count >= C:
            # 공유기를 더 띄엄띄엄 설치할 수 있음
            start = mid + 1
            result = mid

        else:
            # 공유기 사이를 더 좁혀야 원하는 만큼(C) 설치 가능
            end = mid - 1

    return result

print(binary_search(houses, N,C))
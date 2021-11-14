# Q2) N 개의 원소를 가진 집합이 있을 때, 이 원소들의 부분집합을 구하여라. ( 1 <= N <= 8 )
import sys

N = int(input())  # 원소 개수
arr = list(input().split()) # 범위 지정 해줘야 하는지? 공백 기준 범위 지정 하드하게 해줘야 하는지?

# 1을 왼쪽으로 shift한 결과 = 2^N = 부분집합의 개수
for i in range(1 << N):
    # 전체 원소만큼 인덱스를 확인
    for j in range(N):
        # i와 j를 왼쪽으로 shift한 결과를 AND 연산
        # i = 1 일 때
        # 1 & (1<<0) = 001 & 001 = 1
        # 1 & (1<<1) = 001 & 010 = 0
        # 1 & (1<<2) = 001 & 100 = 0
        # 출력 : B
        if i & (1 << j):
            print(arr[j], end='')
    print()

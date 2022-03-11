import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

# 출력값 = i번째 입력의 값보다 작은 수들의 갯수= 입력된 모든 값중 i번째 값의 순서
sort_nums = list(sorted(set(nums)))
dic = {val : idx for idx, val in enumerate(sort_nums)}

for element in nums:
    print(dic[element], end=' ')

# 이분탐색으로 풀어주세여
# 45448KB, 572ms
import sys

# 1. 정수 N, N개의 정수 입력받기/M동일
N = int(sys.stdin.readline())
dict_n = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
check_n = list(map(int, sys.stdin.readline().split()))



# 2. 존재하면 1, 존재하지 않으면 0 출력
def binary_search(dict, dict_len, find):
    start = 0
    end = dict_len-1

    while start<=end:
        mid =  (start+end)//2
        if find == dict[mid]:
            print(1)
            return
        elif find > dict[mid]:
            start = mid + 1
        else:
            end = mid - 1

    print(0)
    return 0

dict_n.sort()
for n in check_n:
    binary_search(dict_n, N, n)
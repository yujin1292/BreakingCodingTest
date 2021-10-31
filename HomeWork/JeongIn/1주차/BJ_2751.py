
# 백준 2751
## KEYWORD : 시간 복잡도, Merge Sort
## POINT : N의 범위가 100만까지 가능하므로 O(NlogN)까지 가능함
## TIP : Python은 시간 초과가 뜨는 경우가 많으니 PyPy를 사용하기를 추천

# def merge_sort(arr):
#     if len(arr)<=1:
#         return arr
#
#     # 1. 재귀 함수로 끝까지 분할
#     mid = len(arr)//2
#     left = merge_sort(arr[:mid])
#     right = merge_sort(arr[mid:])
#
#     i,j,k = 0,0,0
#
#     # 2. 분할된 배열끼리 비교하며 작은 수를 앞으로 정렬해줌
#     while i < len(left) and j < len(right):
#         if left[i] < right[j]:
#             arr[k] = left[i]
#             i+=1
#         else :
#             arr[k] = right[j]
#             j+=1
#         k+=1
#
#     if i == len(left):
#         while j < len(right):
#             arr[k] = right[j]
#             j+=1
#             k+=1
#     elif j ==len(right):
#         while i <len(left):
#             arr[k] = left[i]
#             i+=1
#             k+=1
#
#     return arr



import sys

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    arr.append(int(sys.stdin.readline()))

arr = sorted(arr)

for i in arr:
    print(i)
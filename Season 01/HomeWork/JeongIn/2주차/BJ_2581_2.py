# Prime(에라토스테네스의 체)
# 에라토스테네스의 체를 사용하지 않았을 때와 시간이 똑같이 소요 되는데 이유가 뭘까요??
M = int(input())
N = int(input())

N += 1
prime_list = [True] * N
sum = 0
min = 10001

for i in range(2, int(N**0.5)+1):
    if prime_list[i]:
        for j in range(2*i, N, i):
            prime_list[j] = False


for i in range(M, N):
    if i > 1 and  prime_list[i]:
        sum += i
        if i < min:
            min = i

if sum>0:
    print(sum)
    print(min)

else :
    print(-1)



# # 1. 범위를 정하는 N,M 입력
# M = int(input())
# N = int(input())
#
# # 2. N~M 사이 소수를 계산
# def primeList(m,n):
#     # 에라토스테네스의 체 초기화
#     prime_list = [True] * n
#
#     # n의 최대 약수는 sqrt(n)
#     for i in range(2,int(n**0.5)+1):
#         if prime_list[i] == True:
#             for j in range(i+i, n, i):
#                 prime_list[j] = False
#
#     return [i for i in range(m,n) if prime_list[i] == True]
#
# prime_result = primeList(M,N+1)
#
# if prime_result:
#     print(sum(prime_result))
#     print(min(prime_result))
#
# else :
#     print(-1)

# 소수구하기(Prime, 에라토스테네스의 체)
import sys

# 1. 속도가 향상되는 입력 받기(참고)
M,N = map(int, sys.stdin.readline().split())


# 2. 에라토스테네스의 체
def primeList(m,n):
    # 에라토스테네스의 체 초기화
    prime_list = [True] * n

    # n의 최대 약수는 sqrt(n)
    for i in range(2,int(n**0.5)+1):
        if prime_list[i] == True:
            for j in range(i+i, n, i):
                prime_list[j] = False

    return [i for i in range(m,n) if prime_list[i] == True]

# 3. M~N 범위 안의 소수라면 값 출력
prime_result = primeList(M,N+1)

for p in prime_result :
    print(p)

# 위 코드는 틀렸는데 아래 코드는 됩니다 이유가 뭘까요..? 함수화가 생각보다 시간이 오래 걸리는 건가요???
# M, N = map(int, input().split())
#
# N += 1
# prime_list = [True] * N
# for i in range(2, int(N**0.5)+1):
#     if prime_list[i]:
#         for j in range(2*i, N, i):
#             prime_list[j] = False
# for i in range(M, N):
#     if i > 1:
#         if prime_list[i]:
#             print(i)
# Prime(에라토스테네스의 체)

# 1. 범위를 정하는 N,M 입력
N = int(input())
M = int(input())
prime_list = []

# 2. N~M 사이 소수를 계산
def isPrime(n):
    # n이 1일경우 Prime이 될 수 없음
    if (n<2):
        return False
    # n의 제곱근이 될 때 까지 가능한 수로 나눠보며 점검
    for factor in range(2, int(n**0.5)+1):
        if n%factor == 0:
            return False
    return True

for val in range(N,M+1):
    if (isPrime(val)):
        prime_list.append(val)

if prime_list:
    print(sum(prime_list))
    print(min(prime_list))

else :
    print(-1)

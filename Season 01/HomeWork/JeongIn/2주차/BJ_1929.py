# 소수구하기(Prime, 에라토스테네스의 체)
import sys

# 1. 속도가 향상되는 입력 받기(참고)
M,N = map(int, sys.stdin.readline().split())


# 2. 에라토스테네스의 체
def isPrime(n):
    # n이 1일경우 Prime이 될 수 없음
    if (n<2):
        return False
    # n의 제곱근이 될 때 까지 가능한 수로 나눠보며 점검
    for factor in range(2, int(n**0.5)+1):
        if n%factor == 0:
            return False
    return True

# 3. M~N 범위 안의 소수라면 값 출력
for val in range(M,N+1):
    if (isPrime(val)):
        print(val)
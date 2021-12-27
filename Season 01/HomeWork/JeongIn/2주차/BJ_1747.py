# 소수 & 팰린드롬

# 1. N이 주어짐
N = int(input())

# 2. 소수체크
def isPrime(n):
    # n이 1일경우 Prime이 될 수 없음
    if (n<2):
        return False
    # n의 제곱근이 될 때 까지 가능한 수로 나눠보며 점검
    for factor in range(2, int(n**0.5)+1):
        if n%factor == 0:
            return False
    return True

# 3. 팰린드롬 체크
def isPalindrome(s):
    if s == s[::-1]:
        return True
    return False


for n in range(N, 1000001):
    if isPrime(n) and isPalindrome(str(n)):
        print(n)
        exit(0)

# 100만 이상 중 소수이면서 팰린드롬인 경우
print(1003001)

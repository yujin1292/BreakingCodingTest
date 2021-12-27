import sys

def gcd(a,b):
    # 왜 아래 if문 설정이 불필요한지 궁금합니다!
    # if a>b:
    #     tmp = b
    #     b = a
    #     a = tmp

    while a:
        tmp = a
        a = b%a # 나머지가 0일경우 while 종료
        b = tmp
    return b

# 1. 두 개의 자연수 입력 받음
a, b = map(int, sys.stdin.readline().split())

# 2. 최소공약수, 최대 공배수 출력
print(gcd(a,b))
print(a*b // gcd(a,b))
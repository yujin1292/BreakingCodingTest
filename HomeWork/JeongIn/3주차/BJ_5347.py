# 최소 공배수
import sys
n = int(sys.stdin.readline())

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


for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    print(a*b//gcd(a,b))
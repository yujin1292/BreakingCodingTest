# 소인수분해

# 1. 정수 N이 주어짐
N = int(input())

# 2. 소인수분해하여 오름차순 출력
for factor in range(2, N + 1):
    # 나눠지면 출력, 나눠진 수로 N을 나눔
    while N % factor ==0:
        print(factor)
        N = N / factor
    if N == 1:
        break
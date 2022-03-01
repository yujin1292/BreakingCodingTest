# 가장 긴 증가하는 부분 수열(Longest Increasing Subsequence)
# 예시
# 수열 A = {10,20,10,30,20,50} 인 경우 > {10,20,30,50}이 LIS 이며, 길이는 4

N = int(input()) # 수열 A 의 크기(1~1000)
A = list(map(int, input().split())) # 수열 A (원소는 1~1000)

dp = [1] * N

for i in range(N):
    for j in range(i):
        if A[j] < A[i] :
            dp[i] = max(dp[i], dp[j]+1) # 길이를 계산

print(max(dp)) # 길이 출력
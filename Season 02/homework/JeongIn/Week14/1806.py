import sys

input = sys.stdin.readline

n, s = map(int, input().split())
data = list(map(int, input().split()))

result = 100000
interval_sum = 0
end = 0

for start in range(n):
    # start 는 0부터 시작
    # 현재 부분 합이 s보다 작을 때 end 증가
    while interval_sum < s and end < n:
        interval_sum += data[end]
        end += 1

    # 현재 부분 합이 s보다 크거나 같으면 카운트하고 start 증가
    if interval_sum >= s:
        # s보다 같거나 크면 길이가 최소인지 확인
        result = min(result, end - start)

    interval_sum -= data[start]

if result == 100000:
    print(0)
else:
    print(result)
import sys

N = int(sys.stdin.readline())
# cnt = 0

# #정답
# while True:
#     if (N%5)==0:
#         cnt += (N//5)
#         print(cnt)
#         break
#
#     N += -3
#     cnt += 1
#
#     if N<0:
#         print("-1")
#         break

ans = 0

def dfs(remaining):

    global ans
    global N

    if (remaining % 5) == 0:
        ans += (remaining // 5)
        N = N - remaining
        return

    if (remaining <= 0):
        N = remaining
        return

    N = N-3
    dfs(remaining - 3)
    ans += 1


dfs(N)

if (N < 0):
    print("-1")
else:
    print(ans)
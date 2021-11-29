# 시간은 이전보다 오래걸림
from _collections import deque
import sys

N, M = map(int, sys.stdin.readline().split())
card = list(map(int, input().split()))

ans = 0

def dfs(start, count, card_sum):
    global ans

    if (card_sum > M):
        return
    if (count == 3):
        if(ans < card_sum):
            ans = card_sum
        return
    if (start == N):
        return

    dfs(start+1, count, card_sum)
    dfs(start+1, count+1, card_sum+card[start])

dfs(0,0,0)
print(ans)
# Stack
import sys

# 입력
input = sys.stdin.readline
K = int(input())# 정수
stack = []
for i in range(K):
    ans = int(input())
    if ans == 0:
        stack.pop()
    else:
        stack.append(ans)
# 출력 : 부른 수의 합
print(sum(stack))

# 결과 값은 잘 나오는데 런타임 에러가 발생하는 이유는 뭘까요..

import sys
sys.setrecursionlimit(10000)

NoC = int(sys.stdin.readline()) # 컴퓨터의 수
NoPC = int(sys.stdin.readline()) # 네트워크 상 연결된 컴퓨터 쌍의 수

graph = [[] for _ in range(NoC+1)]

for _ in range(NoPC):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(1,NoPC+1):
    graph[i].sort()

visited = [False] * (NoC+1)

count = -1

def dfs(start):
    visited[start] = True
    global count
    count += 1
    for i in graph[start]:
        if not visited[i]:
            dfs(i)

dfs(1)
print(count)
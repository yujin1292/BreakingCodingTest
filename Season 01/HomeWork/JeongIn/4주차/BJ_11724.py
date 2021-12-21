import sys
sys.setrecursionlimit(1000000)

N , M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

visited = [False for _ in range(N+1)]
count = 0

def dfs(start):
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            dfs(i)

for i in range(1, N+1):
    if not visited[i]:
        count += 1
        dfs(i)

print(count)


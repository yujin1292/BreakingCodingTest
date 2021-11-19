from _collections import deque
import sys

# 0. 정점의 개수 N, 간선의 개수 M, 탐색 시작할 정점의 번호 V
N, M, V = map(int, sys.stdin.readline().strip().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(1,N+1):
    graph[i].sort()


def dfs(start):
    visited[start] = True
    print(start, end=' ') #출력을 위해 필요한 부분
    for i in graph[start]:
        if not visited[i]:
            dfs(i)

def bfs(start):
    queue = deque([start]) # 원소 삽입
    visited[start] = True
    while(queue):
        pop = queue.popleft() # 가장 왼쪽에 있는 원소 제거&리턴
        print(pop, end=' ') #출력을 위해 필요한 부분
        for i in graph[pop]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

visited = [False] * (N+1)
dfs(V)
print()
visited = [False] * (N+1)
bfs(V)

import sys
from _collections import deque

N = int(sys.stdin.readline())

graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)


visited = [0 for _ in range(N+1)]

def bfs(start):
    queue = deque([start]) # 원소 삽입
    visited[start] = True
    while(queue):
        pop = queue.popleft() # 가장 왼쪽에 있는 원소 제거&리턴
        for i in graph[pop]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = pop

bfs(1)
for i in range(2, N+1):
    print(visited[i])

import sys
from _collections import deque

n  = int(sys.stdin.readline())
n1, n2 = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)


visited = [False for _ in range(n+1)]

def bfs():
    queue = deque() # 원소 삽입
    queue.append((0,n1))
    while(queue):
        dist, pop = queue.popleft() # 가장 왼쪽에 있는 원소 제거&리턴
        visited[pop] = True

        for i in graph[pop]:
            if not visited[i]:
                queue.append((dist+1, i))
            if i == n2:
                return dist+1
    return -1

print(bfs())
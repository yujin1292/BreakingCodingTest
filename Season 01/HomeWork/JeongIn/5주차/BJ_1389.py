# 최소 거리 -> BFS

import sys
from _collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)



def bfs(start):
    bacon = [0 for _ in range(N + 1)]
    visited = [False for _ in range(N + 1)]
    queue = deque([start]) # 원소 삽입
    visited[start] = True
    while(queue):
        pop = queue.popleft() # 가장 왼쪽에 있는 원소 제거&리턴
        for i in graph[pop]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                bacon[i] = bacon[pop] + 1
    return sum(bacon)

result = []
for n in range(1, N+1):
    result.append(bfs(n))

# result 값이 min인 index를 반환(result는 idx가 0부터 저장되므로 +1)
print(result.index(min(result))+1)
# 위상정렬 접근
import collections
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split()) # 학생들 수, 비교횟수
in_degree = [0] * (N+1) # 진입 차수 리스트
graph = [[] for i in range(N+1)]

for _ in range(M):
    cur_snum, next_snum = map(int, sys.stdin.readline().split())
    graph[cur_snum].append(next_snum)
    in_degree[next_snum] += 1 # 진입 차수 증가

result = []

# 위상정렬 알고리즘
q = collections.deque()

for i in range(1, N + 1):
    if in_degree[i] == 0:
        q.append(i) # 초기에 진입차수가 0인 학생번호를 큐에 넣음

while q:
    now_snum = q.popleft()
    result.append(now_snum) # 큐에서 학생을 꺼내 줄을 세움
    for link_snum in graph[now_snum]:
        in_degree[link_snum] -= 1 # 진입차수 감소 시킴
        if in_degree[link_snum] == 0:
            q.append(link_snum) # 새롭게 진입차수가 0이 된 학생번호를 큐에 넣음

for snum in result:
    print(snum, end=' ')
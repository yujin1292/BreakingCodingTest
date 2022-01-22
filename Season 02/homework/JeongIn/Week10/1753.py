# 다익스트라 알고리즘
# V줄에 걸쳐서
# i번째 줄에 i번 정점으로의 최단 경로의 경로값 출력

# 시작점 자신은 0
# 경로가 존재하지 않는다면 INF

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
V, E = map(int, input().split())

# 시작 노드 번호를 입력받기
K = int(input())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for _ in range(V + 1)]

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (V + 1)

# 모든 간선 정보를 입력받기
for _ in range(E):
    a, b, c = map(int, input().split())
    # a 도시에서 b 도시 가는 데 드는 버스 비용은 c
    graph[a].append((b, c))

# 우선순위 큐로 푸는 방법!
def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0
    # 최단 경로를 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q :
        # 가장 최단 거리가 짧은 노드 거리 꺼내기
        dist, now = heapq.heappop(q)

        # 현재 노드가 처리 유무 확인
        if distance[now] < dist :
            continue

        # 현재 노드와 연결된 다른 인접 노드 확인
        for near_v in graph[now]:
            cost = dist + near_v[1]

            # 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[near_v[0]]:
                distance[near_v[0]] = cost
                heapq.heappush(q, (cost, near_v[0]))

# 다익스트라 알고리즘 수행
dijkstra(K)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")

    else :
        print(distance[i])

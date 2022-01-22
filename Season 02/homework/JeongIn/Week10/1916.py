# 다익스트라 알고리즘
# 출발 도시에서 도착 도시까지 가는데 드는 최소 비용

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 도시의 수, 버스의 수 입력
N = int(input().rstrip())
M = int(input().rstrip())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for _ in range(N + 1)]

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (N + 1)

# 모든 간선 정보를 입력받기
for _ in range(M):
    u, v, w = map(int, input().split())
    # u번 노드에서 v번 노드로 가는 비용이 w라는 의미
    graph[u].append((v, w))

# 출발지점 도시 번호(A), 도착지점 도시 번호(B)
start, end = map(int, input().split())


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
dijkstra(start)

# 종료 지점만 출력
print(distance[end])

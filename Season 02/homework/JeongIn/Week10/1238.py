# 다익스트라 알고리즘
# N개의 숫자로 구분된 마을에 초기 값 1(명의 학생)
# 다른 마을에 모여 파티를 벌이기로 함
# M 개의 단방향 도로 = 간선을 의미, 가중치는 걸리는 시간 T
# 가장 많은 시간을 소비하는 학생은?

import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드, 간선, 모이기로 한 마을 입력
N, M, X = map(int, input().split())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for _ in range(N + 1)]


# 모든 간선 정보를 입력받기
for _ in range(M):
    u, v, t = map(int, input().split())
    # u번 노드에서 v번 노드로 가는 비용이 w라는 의미
    graph[u].append((v, t))



# 우선순위 큐로 푸는 방법!
def dijkstra(start):
    # 최단 거리 테이블을 모두 무한으로 초기화
    distance = [INF] * (N + 1) # 이전 문제까지 함수 밖에서 초기화해준 거리값이 반환되어야 했으므로 함수 안으로 넣어줘야 함

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
            cost = dist + near_v[1] # 인접 노드 거치는 거리 계산

            # 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[near_v[0]]:
                distance[near_v[0]] = cost # 최단 거리를 바꿔줌
                heapq.heappush(q, (cost, near_v[0]))
    return distance

# X로 가는 시간과 X에서 본인의 마을로 오는 시간의 합이 가장 큰 사람의 시간을 출력해야 함
result = 0
for i in range(1, N+1):
    to_x = dijkstra(i)[X] # i번째 마을에서 에서 X까지 가는 데 걸리는 시간
    from_x = dijkstra(X)[i] # X에서 i번째 마을로 돌아오는데 걸리는 시간
    result = max(result, to_x + from_x)

print(result)

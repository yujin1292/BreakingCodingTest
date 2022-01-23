import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들고 무한으로 초기화
graph = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신과의 거리는 0으로 처리
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

# 모든 간선 정보를 입력받기
for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미

# floyd-warshall algorithm
# 모든 노드에서 모든 노드로의 최단 거리 값을 순회하며 min 값을 갱신해나간다.
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 모든 노드로 가기 위한 최단 거리를 출력
for a in range(1, n + 1):
    for b in range(1, n + 1):

        # 도달할 수 없는 경우, INFINITY 출력
        if graph[a][b] == INF:
            print("INFINITY")

        # 도달할 수 있는 경우, 거리를 출력
        else:
            print(graph[a][b])
    print()
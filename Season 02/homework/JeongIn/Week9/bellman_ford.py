import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())

# 시작 노드 번호를 입력받기
start = int(input())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n + 1)]

# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False] * (n + 1)

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    graph[a].append((b, c))


# 벨만 포드 알고리즘
def bf(start):
    distance[start] = 0  # 시작 노드에 대해서 거리를 0으로 초기화
    for i in range(n):  # 정점 수만큼 반복
        for j in range(m):  # 매 반복 마다 모든 간선 확인
            now = graph[j][0]  # 현재 노드 받아오기
            next_node = graph[j][1]  # 다음 노드 받아오기
            cost = graph[j][2]  # 가중치 받아오기

            # 현재 간선을 거려서 다른 노드로 이동하는 거리가 더 짧은 경우
            if distance[now] != INF and distance[next_node] > distance[now] + cost:
                distance[next_node] = distance[now] + cost
                # n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i == n - 1:  # n-1번 이후 반복에도 값이 갱신되면 음수 순환 존재
                    return True
    return False


# 벨만 포드 알고리즘 수행
negative_cycle = bf(1)

if negative_cycle:
    print('-1')
else:
    # 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단 거리 출력
    for i in range(2, n + 1):
        if distance[i] == INF:  # 도달할 수 없는 경우, 무한(INFINITY)출력
            print('INFINITY')
        else:  # 도달할 수 있는 겨우 거리를 출력
            print(distance[i])
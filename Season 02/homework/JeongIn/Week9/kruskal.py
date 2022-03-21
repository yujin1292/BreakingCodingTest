import sys

n, m = map(int, input().split()) # vertex, edge 의 수 입력

# 부모 테이블을 중복되지 않는 값으로 초기화
parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

# find 연산
def find(x):
    if parent[x] < 0:
        return x
    else :
    	# 루트노드가 아니라면, 루트노드를 찾을 때까지 재귀적으로 호출
        parent[x] = find(parent[x])
        return parent[x]

# union 연산
def union(a,b) :
    a = find(a)
    b = find(b)
    if a != b :
    	# 두 원소가 속한 집합을 합치기
        parent[a] = b

# 간선 정보 담을 리스트와 최소 신장 트리 계산 변수 정의
edges = []
total_cost = 0

# 간선 정보 주어지고 비용을 기준으로 정렬
for _ in range(m):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

# 간선 정보 비용 기준으로 오름차순 정렬
edges.sort()

# 간선 정보 하나씩 확인하면서 크루스칼 알고리즘 수행
for i in range(m):
    cost, a, b = edges[i]
    # find 연산 후, 부모노드 다르면 사이클 발생되지 않으므로 union 연산 수행 = 최소 신장 트리에 포함!
    if find(a) != find(b):
        union(a, b)
        total_cost += cost

print(total_cost) # 최소 신장 트리의 총 가중치 값 출력(옵션)
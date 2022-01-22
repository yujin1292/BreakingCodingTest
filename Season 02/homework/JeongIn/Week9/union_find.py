import sys

sys.setrecursionlimit(10 ** 9)

n, m = map(int, sys.stdin.readline().rstrip().split())  # 노드 및 간선의 갯수 입력 받기

# 1. 초기화
parent = [-1 for _ in range(n + 1)]


# 2. union기능
def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        # 두 원소가 속한 집합을 합치기
        parent[a] = b


# 3. find 기능
def find(x):
    if parent[x] < 0:
        return x
    else:
        # 루트노드가 아니라면, 루트노드를 찾을 때까지 재귀적으로 호출
        parent[x] = find(parent[x])
        return parent[x]


# 4. 부모 테이블상에서, 부모를 자기 자신으로 초기화
parent = [0] * (n + 1)  # 부모 테이블 초기화하기

for i in range(1, n + 1):
    parent[i] = i

# 5. Union 연산을 각각 수행
for i in range(m):
    a, b = map(int, input().split())
    union(a, b)

# 번외 1) 각 원소가 속한 집합 출력하기
print('각 원소가 속한 집합: ', end='')
for i in range(1, n + 1):
    print(find(i), end=' ')

# 번외 2) 부모 테이블 내용 출력하기
print('부모 테이블: ', end='')
for i in range(1, n + 1):
    print(parent[i], end=' ')
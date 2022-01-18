# 최단 거리 / 최소 비용 알고리즘

## 최단 거리

### Dijkstra 알고리즘
> - **시작 정점에서 특정 정점**까지의 최단거리를 알기 위한 알고리즘이다.
> - 매 상황에서, **가장 비용이 적은(가까운) 노드를 선택**하여 과정을 반복한다.
> ### 주요 특징
> **음의 간선**이 없을 때만 작동한다.

~~~ python
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

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

# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
def get_smallest_node():
    min_value = INF
    index = 0 # 가장 최단 거리가 짧은 노드(인덱스)
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index

def dijkstra(start):
    # 시작 노드에 대해서 초기화
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]
        
    # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
    for i in range(n - 1):
        # 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
        now = get_smallest_node()
        visited[now] = True
        
        # 현재 노드와 연결된 다른 노드를 확인
        for j in graph[now]:
            cost = distance[now] + j[1]
            
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[j[0]]:
                distance[j[0]] = cost

# 다익스트라 알고리즘을 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    # 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
    if distance[i] == INF:
        print("INFINITY")
    # 도달할 수 있는 경우 거리를 출력
    else:
        print(distance[i])
~~~

### Floyd Warshall 알고리즘
> **모든 정점에서 모든 정점으로의** 최단 경로를 구하는 경우 사용된다.


~~~ python
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

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
 
~~~

### Bellman-Ford 알고리즘
> - **시작 정점부터 특정 정점**까지의 최단거리를 알기 위한 알고리즘이다.
>### 주요 특징
> - 음수 가중치가 있는 그래프의 시작 정점에서 다른 정점까지의 최단 거리를 구할 수 있다.
> - 음수 사이클 존재의 여부를 알 수 있다.


~~~ python
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

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
    distance[start] = 0 # 시작 노드에 대해서 거리를 0으로 초기화
    for i in range(n): # 정점 수만큼 반복
        for j in range(m): # 매 반복 마다 모든 간선 확인
            now = graph[j][0] # 현재 노드 받아오기
            next_node = graph[j][1] # 다음 노드 받아오기
            cost = graph[j][2] # 가중치 받아오기
            
            # 현재 간선을 거려서 다른 노드로 이동하는 거리가 더 짧은 경우
            if distance[now] != INF and distance[next_node] > distance[now] + cost:
                distance[next_node] = distance[now] + cost
                # n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i == n-1: # n-1번 이후 반복에도 값이 갱신되면 음수 순환 존재
                    return True
    return False

# 벨만 포드 알고리즘 수행
negative_cycle = bf(1)

if negative_cycle:
    print('-1')
else:
    # 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단 거리 출력
    for i in range(2, n+1):
        if distance[i] == INF: # 도달할 수 없는 경우, 무한(INFINITY)출력
            print('INFINITY')
        else: # 도달할 수 있는 겨우 거리를 출력
            print(distance[i])
~~~

### Dijkstra vs Floyd Warshall
1. 차이점
- `Dijkstra는 한 노드에서부터 특정 노드까지의 최소거리를 계산하지만, Floyd Warshall은 모든 노드에서 모든 노드로의 최소 거리를 계산한다. `
 - ` Dijkstra 는 최단 거리가 1차원 테이블에 저장되며, Floyd Warshall 은 최단 거리가 2차원 테이블에 저장된다.`
 - ` Dijkstra 의 시간 복잡도는 O(ElogV)이고, Floyd Warchall 의 시간 복잡도는 O(N^3) 이다.`
 - ` "순회하지 않는 경우" Floyd Warchall 은 음수 가중치가 가능하다 `
 
2. 공통점
 - ` 테이블(리스트)을 사용해서 최단 거리를 기록한다. `
 - ` 최단 경로를 찾는 것을 목표로 한다. `
 - ` "순회하는 경우" 음수 가중치가 불가능하다. `
 
### Floyd Warshall vs Bellman-Ford
 
 1. 차이점
 - ` Bellman-Ford 에서는 인접 간선을 검사하고 거리 값을 갱신하는 과정을 V-1번으로 제한하므로 음수 사이클을 방지할 수 있다. Floyd Warshall 은 "순회하는 경우" 음수 가중치가 불가능하다. `
 - ` Bellman-Ford 는 최단 거리 테이블이 사용되는 반면, Floyd Warshall 은 그래프 자체에 최단 거리값이 갱신되어 저장된다. `
 
2. 공통점
 - ` 매 반복마다 모든 노드와의 거리 값을 확인한다.`
 - ` "순회하지 않는 경우" 음수 가중치가 가능하다 `
 - ` 한 노드에서 다른 모든 노드로의 최단 경로가 계산된다. `

## 최소 비용 

### What is `Union Find`? 
> **트리형태를 갖는 자료구조**이며, 트리들을 이루는 노드는 **모두 다른 값** 이므로, **상호 배타적 집합**이라고도 불린다.
>
> Union Find에는 두 가지 핵심 연산이 존재한다.
>
> **1) Union :** 두 집합을 하나의 집합으로 합치는 연산
> **2) Find :** 어떤 원소 x가 주어졌을 때 이 원소가 속한 집합을 반환
>
> Union Find는 루트 노드(Root node)찾기, 집합 합치기(합집합)에 유용하게 사용된다.


~~~ python
import sys
sys.setrecursionlimit(10**9)

n, m = map(int,sys.stdin.readline().rstrip().split()) # 노드 및 간선의 갯수 입력 받기

# 1. 초기화
parent = [-1 for _ in range(n+1)]


# 2. union기능 
def union(a,b) :
    a = find(a)
    b = find(b)
    if a != b :
    	# 두 원소가 속한 집합을 합치기
        parent[a] = b

# 3. find 기능
def find(x) :
    if parent[x] < 0:
        return x
    else :
    	# 루트노드가 아니라면, 루트노드를 찾을 때까지 재귀적으로 호출
        parent[x] = find(parent[x])
        return parent[x]
        

# 4. 부모 테이블상에서, 부모를 자기 자신으로 초기화
parent = [0] * (n + 1) # 부모 테이블 초기화하기

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

~~~

## Kruskal's Algorlthm
> **구현 방법**
>	1) 가중치가 증가하는 순서대로 **정렬**한다.
> 	2) 만약, **가중치가 가장 작은 간선**이 **사이클을 만들지 않으면** 트리 간선으로 **선택**한다.
>	3) 2번 과정을 반복해서 ```(정점-1)``` 개의 간선을 만들면 중단된다.
>
> **결과**
> 최소 신장 트리(최소 가중치를 갖는 무방향 가중치 그래프)
> [참고](https://techblog-history-younghunjo1.tistory.com/262)

~~~ python
import sys

n, m = map(int, input().split()) # vertex, edge 의 수 입력

# 부모 테이블을 중복되지 않는 값으로 초기화
parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

# find 연산
def find_parent(x):
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
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        total_cost += cost

print(total_cost) # 최소 신장 트리의 총 가중치 값 출력(옵션)
~~~

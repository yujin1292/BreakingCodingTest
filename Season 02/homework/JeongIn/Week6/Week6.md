# Week 6 Study Log

## Graph

### Graph란?
- **정점(Vertex)** 과 **간선(Edge)** 으로 이루어진 자료구조
- 정점(Vertex) : 노드(Node)라고도 불리며, 데이터가 저장됨
- 간선(Edge) : 링크라고도 불리며, 노드간의 관계를 나타냄
</br>
</br>

### Graph와 Tree의 차이점
| |그래프|트리|
|------|---|---|
|정의|노드와 간선으로 이루어진 자료구조|방향성이 있는 **비순환 그래프**|
|방향성|방향 및 무방향|방향|
|순환|순환 및 비순환 (자체 순환 가능)|비순환|
|모델|네트워크 모델(비계층 모델)|계층적 모델|
|간선의 수|자유(0개 허용)|정점의 수-1|
|순회|DFS,BFS|Pre-order, In-order, Post-order|
|실생활의 예|지하철 노선도|회사의 조직도|
</br>
</br>


### Graph를 표현 하는 방법들
| |무방향 그래프|방향 그래프|가중치 그래프|
|------|:---:|:---:|:---:|
|정의|양쪽으로 이어진<br/>방향성이 없는 그래프|한쪽으로<br/> 방향이 정해진 그래프|간선에<br/> 비용이 정해진 그래프|
|방향|양방향 가능|한방향 가능|무방향 및 방향
|(A,B) 의미|A↔️B|A➡️B|
<br/>
<br/>

## DFS

### DFS 란?
**깊이 우선 탐색(Depth-First Search)** 의 줄임말로, 임의의 노드에서 부터 다음 분기로 넘어가기 전 한 분기를 완전히 탐색하는 방식을 의미함

### Python으로 DFS 구현하기

```
visited = [False] * (N+1)

def dfs(start):
    visited[start] = True
    
    for i in graph[start]:
        if not visited[i]:
            dfs(i)
```

### DFS를 응용하여 풀 수 있는 문제
1. 모든 노드를 방문해야 할 때
2. 검색 대상의 그래프가 클 때
3. 경로의 특징을 저장해야 할 때
<br/>
<br/>

## BFS

### BFS 란?
**넓이 우선 탐색((Breadth-First Search)** 의 줄임말로, 시작 노드와 같은 깊이의 노드를 우선 방문하고 가장 멀리 떨어진 깊이의 노드를 가장 나중에 방문하여 탐색하는 방식을 의미함

### Python으로 BFS 구현하기
```
visited = [False] * (N+1)

def bfs(start):
    queue = deque([start]) # 원소 삽입
    visited[start] = True
    while(queue):
        pop = queue.popleft() # 가장 왼쪽에 있는 원소 제거&리턴
        for i in graph[pop]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
```


### BFS 를 응용하여 풀 수있는 문제
1. 모든 노드를 방문해야 할 때
2. 최단 거리를 계산해야 할 때
import sys
input = sys.stdin.readline

# 트리 : 사이클 없이 이어져야 함

test_case = 1 # 테스트 케이스 카운트용

def dfs(prev, now):
    visited[now] = True # 방문 처리

    for next in graph[now]:
        # 다음 노드가 이전 노드와 같다면 사이클을 의미하므로 DFS 수행 X
        if next == prev:
            continue
        # 다음 노드가 이전 노드와 같지 않은데 이미 방문 했다면 사이클을 의미하므로 DFS 수행 X
        if visited[next]:
            return False
        # 다음 노트가 이전 노드와 같지 않고, 처음 방문해야 DFS 수행 가능
        # 중간에 사이클이 생기는 경우(if not) DFS를 중단하고 돌아옴
        if not dfs(now, next):
            return False
    # 쭉 DFS 성공한 경우만 True 반환됨
    return True

# 테스트케이스의 수가 정해져있지 않으므로 while로 실행
while True:

    # 입력 구간
    n, m = map(int, input().split())  # 입력 : 정점 및 간선의 갯수
    if [n, m] == [0,0]:
        break # n,m에 아무 값도 받지 못한 경우


    graph = [[] for _ in range(n+1)] # 그래프
    visited = [False] * (n+1) # 방문 여부 확인 배열
    for _ in range(m):
        n1, n2 = map(int, input().split())
        graph[n1].append(n2)
        graph[n2].append(n1)

    # DFS 성공 횟수로 트리의 수를 계산
    tree_cnt = 0  #트리의 수

    for v in range(1, n+1):
        if not visited[v]:
            if dfs(0, v):
                tree_cnt += 1 # 사이클이 없는 경우 트리 수 증가

    if tree_cnt == 0 :
        print("Case {}: No trees.".format(test_case))
    elif tree_cnt == 1 :
        print("Case {}: There is one tree.".format(test_case))
    else :
        print("Case {}: A forest of {} trees.".format(test_case, tree_cnt))

    test_case += 1 # 출력을 위한 테스트 케이스 수






# 출력
# 주어진 그래프에 트리가 없을 경우 -> "Case 1: No trees."
# 트리가 한 개라면 -> "Case 2: There is one tree."
# T 개라면 -> "Case 3: forest of T trees."


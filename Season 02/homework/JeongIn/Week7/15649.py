# DFS 백트래킹으로 접근
N, M = map(int, input().split()) # 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

visited = [False] * N
res = [] # 결과를 담을 리스트

def dfs(depth):
    if depth == M: # M길이의 수열이 완성되었을 경우
        for ele in res:
            print(ele, end=' ')
        print('')
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            res.append(i+1)
            dfs(depth+1)
            visited[i] = False
            res.pop()
dfs(0)
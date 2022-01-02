# 15649와의 차이점 : 중복 가능!
# 마찬가지로 dfs 백트래킹으로 접근

N, M = map(int, input().split())
res = []

def dfs(depth):
    if depth == M: # M길이의 수열이 완성되었을 경우 출력
        for ele in res:
            print(ele, end=' ')
        print('')
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True # 중복 방지를 위한 방문 표시
            res.append(i+1) # Depth 가 곧 원소이므로 res 에 추가
            dfs(depth+1) # 다음 깊이 탐색
            visited[i] = False
            res.pop() # 다음 수열을 저장하기 위한 공간 초기화
dfs(0)


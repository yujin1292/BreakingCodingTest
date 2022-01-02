# DFS 백트래킹으로 접근
N, M = map(int, input().split()) # 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

res = [] # 결과를 담을 리스트

def dfs(depth):
    if depth == M: # M길이의 수열이 완성되었을 경우 출력
        for ele in res:
            print(ele, end=' ')
        print('')
        return

    for i in range(N):
        res.append(i+1) # Depth 가 곧 원소이므로 res 에 추가
        dfs(depth+1) # 다음 깊이 탐색
        res.pop() # 다음 수열을 저장하기 위한 공간 초기화
dfs(0)
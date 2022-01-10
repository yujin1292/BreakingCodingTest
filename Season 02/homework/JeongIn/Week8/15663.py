# DFS 백트래킹으로 접근
N, M = map(int, input().split()) # N개의 자연수와 자연수 M이 주어졌을 때 길이가 M인 수열을 모두 골라야 함
nums = sorted(list(map(int, input().split()))) # N개의 자연수
visited = [False] * N # 특정 자연수를 거쳐갔음을 표시하기 위한 리스트
result = []

def dfs():
    if len(result) == M :
        # M 길이인 경우
        print(*result)
        return

    prior = 0 # 이전의 숫자가 현재 숫자와 중복되는 경우 중복 수열을 만들게 되는 현상을 방지하기 위함

    for i in range (N):
        if not visited[i] and prior != nums[i]:
            # 직전 숫자가 현재(i번째) 숫자와 같은 경우 중복 수열을 만드므로 건너뜀
            visited[i] = True
            result.append(nums[i]) # 수열 결과에 숫자 추가
            prior = nums[i] # 수열에 포함시킨 가장 최근 숫자 저장
            dfs() # 다음 숫자 추가를 위한 dfs
            visited[i] = False # 다른 숫자를 포함시켜보기 위해 False 로 변경
            result.pop() # 다른 숫자의 경우도 진행해보기 위해 최근 숫자 빼줌

dfs()
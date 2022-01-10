# 어렵게 풀어서 다시 풀어보고 싶은 문제는 re_ 태그를 붙여주었습니다!

# BFS 로 접근
from collections import deque

# 축구 하려는 N명 및 능력치 배열 S 입력
N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]
visited = [False] * N
min_diff = 1000 # 한 팀이 가질 수 있는 최대 능력치는 최대 N 값 20/2 * 100 * 2 = 1000


# N = 4 인경우
# visited = [T,T,F,F] 일 때 depth는 2가 되어 아래 if 문에 걸림
# 이 경우는 1,2번이 한 팀에 속했을 경우를 의미 함
# 즉, visited 에서 T가 두 번째 나타나는 순간 팀 배정은 종료되므로 능력치 차이를 구할 수 있음

# N = 6 인경우
# visited = [T,T,T,F,F,F] 일 때 depth 는 3이 되어 아래 if 문에 걸림
# 이 경우는 1,2,3번이 한 팀에 속했을 경우를 의미 함
# 즉, S_01 + S_10 + S_20 + S_02 + S_12 + S_21 이 이 팀의 총 능력치가 됨


def dfs(depth, pos):
    global min_diff

    if depth == N//2:
        # 팀 배정이 종료되었을 경우
        start, link = 0, 0

        # (i,j)를 중복없이 탐색하며 능력치의 합을 구함
        for i in range(N):
            for j in range(i+1,N):
                if visited[i] and visited[j]:
                    # True팀(start 라고 가정)일 경우
                    start += S[i][j] + S[j][i]
                elif not visited[i] and not visited[j]:
                    # False팀(link 라고 가정)일 경우
                    link += S[i][j] + S[j][i]

        min_diff = min(min_diff, abs(start-link)) # 현재 방법으로 팀을 배정했을 시 두 팀의 능력치 차이 저장 # 방법에 따라 갱신 될 수 있음
        return

    for i in range(pos, N):
        if not visited[i]:
            visited[i] = True # i번 줄 선수가 포함될 경우 (스타트 팀일 경우) 고려
            dfs(depth+1, i+1) # depth 는 현재 몇 명의 선수를 뽑았는 지를 의미하며, pos 는 마지막으로 확정된 선수의 번호를 의미 함
            visited[i] = False # i번 줄 선수가 포함되지 않을 경우 (링크 팀일 경우) 고려

dfs(0,0)
print(min_diff)
# 14226 이모티콘

import sys
from collections import deque
input = sys.stdin.readline

S = int(input()) # 만들어야 하는 이모티콘 수

# 출력 : 이모티콘 만드는데 필요한 시간
# 이모티콘 복붙 가능
# 이모티콘 1개 삭제 가능


visited = [[-1] * (S+1) for _ in range(S+1)] # 화면, 클립보드에 저장된 이모티콘 수에 해당하는 이차원 배열

def bfs():
    q = deque()
    q.append([1,0]) # 처음엔 화면에 이모티콘 1개, 클립보드엔 0개
    visited[1][0] = 0 # 방문 표시

    while q:
        disp, clip = q.popleft()

        # 1. 화면에 있는 disp개의 이모티콘을 클립보드에 저장할 경우
        if visited[disp][disp] == -1:
            visited[disp][disp] = visited[disp][clip]+ 1 # 시간 증가
            q.append([disp, disp])

        # 2. 클립보드에 있는 clip개의 이모티콘을 화면에 붙이는 경우
        if disp + clip <= S and visited[disp+clip][clip] == -1:
            visited[disp+clip][clip] = visited[disp][clip] + 1
            q.append((disp+clip, clip))

        # 3. 화면에 있는 disp개의 이모티콘 중 하나를 삭제하는 경우
        if disp -1 >=0:
            visited[disp-1][clip] = visited[disp][clip] + 1
            q.append((disp-1, clip))

        # 원하는 이모티콘 수를 다 화면에 출력한 경우
        if disp == S:
            print(visited[disp][clip]) # 최초 시간 출력 (=최소 시간)
            break

bfs()

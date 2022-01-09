# BFS 로 접근 -> 최단 거리 문제

from collections import deque
N, K = map(int, input().split()) # N : 수빈 위치 / K : 동생 위치
visited = [0] * 100001 # 가장 멀리 떨어져있을 경우, 100000까지 방문해야 할 수 있음
# visited 가 방문 표시뿐만 아니라 걸린 시간(출력)도 함께 포함해야하므로 False 가 아닌 0으로 된 배열로 초기화 해줌

# 예)
# 시작점이 5, 도착점이 17
# 1초 후 -> (4 / 6 / 10 으로 이동 가능)
# 2초 후 -> ((3 / 5 / 8) , (5 / 7 / 12) , (9 / 11 / 20) 으로 이동 가능 --> 점점 수가 늘어남..)



def bfs():
    q = deque()
    q.append(N) # 수빈이의 현재 위치 추가

    while q:
        x = q.popleft() # 현재 수빈이의 위치를 반환

        if x == K :
            # 동생 찾았을 경우 출력하고 반복문 종료
            print(visited[x])
            break

        for new_x in (x-1, x+1, x*2):
            if 0 <= new_x <= 100000 and visited[new_x]==0:
                visited[new_x] = visited[x]+1 # visited 에 해당 위치까지 걸린 시간도 함께 포함해줌
                q.append(new_x) # 현재 위치 추가해줌

bfs()
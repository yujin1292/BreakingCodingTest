# 1976 여행가자
# https://www.acmicpc.net/problem/1976
import sys
sys.setrecursionlimit(10**6) # 재귀시 필수
input = sys.stdin.readline

N = int(input()) # 도시의 수
M = int(input()) # 여행 계획에 속한 도시들의 수


# 주어진 순서가 가능한 지 판별해야 함 -> 이어져있는 지 판별
parent = [i for i in range(N+1)] # 부모 테이블 생성


def find(x):
    if x == parent[x]:
        return x

    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    # 부모가 같을 경우
    if x == y :
        return

    if x<y:
        parent[y] = x # y의 부모는 x 부모(더 상위 부모)

    else:
        parent[x] = y


for city in range(1, N+1):
    maps = list(map(int, input().split())) # 연결 정보 입력

    for link_city in range(1, len(maps)+1):
        if maps[link_city-1] == 1: # link_city와 연결되어 있으면
            union(city, link_city) # 두 도시를 결합



plan = list(map(int, input().split())) # 여행 계획 정보
ans = set([find(i) for i in plan]) # 여행 계획의 루트 노드 찾기

if len(ans) >= 2:
    print('NO') # 집합 수가 2개 이상이면 모든 도시가 이어진게 아님

else:
    print('YES')
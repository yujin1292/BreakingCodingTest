import sys

input = sys.stdin.readline
board = [list(map(int, input().split())) for _ in range(10)]
usable = [0, 5, 5, 5, 5, 5] # 사용하능는 색종이 개수
result = set() # 중복된 값을 미리 막아줌 / 평균 시간 복잡도 O(1)


# 색종이 최대 길이 구하는 함수
def find_length(y, x):
    length = 1
    # 오른쪽, 아래쪽으로 확장되어 사각형 최대 길이가 정해짐
    # min : 배열 범위를 벗어나는 경우 방지
    for l in range(2, min(10 - y, 10 - x, 5) + 1):
        for i in range(y, y + l):
            for j in range(x, x + l):
                if board[i][j] == 0:
                    return length
        length += 1
    return length


# 색종이 덮는 함수
def cover(y, x, length):
    for i in range(y, y + length):
        for j in range(x, x + length):
            board[i][j] = 0


# 색종이 치우는 함수
def uncover(y, x, length):
    for i in range(y, y + length):
        for j in range(x, x + length):
            board[i][j] = 1


def dfs(cnt):
    for i in range(0, 10):
        for j in range(0, 10):
            # 아직 덮어야 할 1이 남았을 경우 계속 진행
            if board[i][j] == 1:
                length = find_length(i, j) # 최대 길이를 찾음
                for l in range(length, 0, -1):
                    # 색종이 길이를 length(최대) 에서 1씩 줄여가며 가능한 큰 사이즈로 덮음
                    if usable[l]:
                        cover(i, j, l) # 위치와 덮을 크기 입력
                        usable[l] -= 1 # 사용한 색종이 크기 나머지 배열에 반영
                        result.add(dfs(cnt + 1)) # 사용된 색종이 갯수 추가
                        uncover(i, j, l) # 이전에 사용한 색종이 지우고 원상 복귀
                        usable[l] += 1 # 갯수도 다시 채워넣기
                if result:
                    return min(result)
                else:
                    return -1 # 결과 집합에 요소가 없다면 모든 칸을 0으로 채우지 못했다는 뜻
    return cnt


result.add(dfs(0)) # dfs 수행

if -1 in result:
    result.remove(-1)
print(min(result) if result else -1) # 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수
# DFS 백트래킹으로 접근
# 0으로 탈출하기 때문에 함수 정의 후 각 변수들 초기화

def dfs(pos):
    if len(case) == 6:
        print(*case)
        return

    for i in range(pos, k):
        if not visited[i] :
            visited[i] = True
            case.append(lottos[i]) # 로또 숫자 추가
            pos += 1 # 중복 방지를 위한 위치 기억
            dfs(pos)
            case.pop()
            visited[i] = False


while True :
    lottos = list(map(int, input().split()))
    k = lottos.pop(0) # 첫 번째 수는 k
    if k != 0 :
        visited = [False] * k
        case = [] # 입력한 수열에서 로또 번호 6개를 뽑는 경우의 수를 저장
        pos = 0 # 중복되는 집합을 피하기 위함 (순서 상관없이 중복되면 안됨)
        dfs(pos)
        print()

    else :
        break
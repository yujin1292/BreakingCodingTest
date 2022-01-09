# DFS 백트래킹으로 접근

# 암호는 서로 다른 L개의 알파벳 소문자로 구성
# 최소 한 개의 모음, 두 개의 자음으로 구성됨

L, C = map(int, input().split()) # L 글자 단어를 C 단어 조합으로 만듦
visited = [False] * C
alpha = sorted(list(map(str, input().split()))) # N개의 알파벳은 정렬된 상태
result = []
vowels = ['a','e','i','o','u']
check_num_vowel = 0

def dfs(pos):
    global check_num_vowel

    if len(result) == L and check_num_vowel>=1 and len(result) - check_num_vowel >=2:
        # M 길이인 경우
        print(''.join(result))
        return

    for i in range(pos, C):

        if not visited[i] :
            # 조건에서 중복되지 않는 알파벳이 주어진다고 정해졌으므로 prior 체크 필요 없음
            visited[i] = True

            if alpha[i] in vowels:
                check_num_vowel+=1

            result.append(alpha[i]) # 수열 결과에 알파벳 추가
            pos += 1
            dfs(pos) # 다음 알파벳 추가를 위한 dfs
            visited[i] = False # 다른 알파벳 포함시켜보기 위해 False 로 변경

            if alpha[i] in vowels:
                check_num_vowel-=1

            result.pop() # 최근 알파벳 제거

dfs(0)

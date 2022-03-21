# 1. N게 지얀스 증 M개 고른 수열
# 2. 중복 허용
# 3. 비내림차순


N, M = map(int, input().split())

nums = sorted(list(set(map(int, input().split()))))
ans_list = []

def dfs(depth):
     # 백트래킹 접근
    if depth == M :
        # M크기인 경우 출력
        print(' '.join(map(str, ans_list)))
        return

    for _, num in enumerate(nums):
        # 시작점이거나 비내림차순에 해당되는 경우
        if depth == 0 or ans_list[-1] <= num:
            ans_list.append(num)
            dfs(depth+1)
            ans_list.pop()

dfs(0)

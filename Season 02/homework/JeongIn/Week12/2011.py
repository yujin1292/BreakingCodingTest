# 고난이도 문제.....
# 문제 이해를 위해 참고한 블로그 : https://archive-me-0329.tistory.com/23?category=965963
# 알파벳 : 1~26
# 암호 자리 : 5000 이하
# 해석 불가한 경우 : 0이 맨 앞자리인 경우
# 출력 : 해석 가짓 수 / 1000000

# 10 이하인 경우 -> 1가지
# 11~26 -> 2가지
# 27~99 -> 1가지
# 100 -> 불가
# code = 디코딩해야 하는 코드
# 두 자리수 디코딩이 되는 경우와 한 자리수 디코딩이 되는 경우를 분리
# 디코딩이 되지 않는 경우는 01과 같이 첫 자리가 0인 경우, 한 자리 수가 0인 경우

import sys

input = sys.stdin.readline

code = list(str(input().strip()))
dp = [0] * (len(code)+1)
dp[0], dp[1] = 1, 1

if code[0] == '0':
    print(0) # 코드의 첫 번째 자리가 0인경우 디코딩 불가
else:
    for i in range(2, len(code) + 1):
        if int(code[i - 1]) > 0:
            # 0보다 큰 수일 경우(0~9) 알파벳으로 디코딩 가능
            dp[i] += dp[i - 1]
        second_case_int = int(code[i - 2] + code[i - 1]) # 두 자리 수일 가능성을 염두
        if 10 <= second_case_int <= 26:
            # 두 자리 수가 10 이상, 26 이하, 즉 알파벳 범위에 속할 경우 해당 알파벳으로 디코딩 가능
            dp[i] += dp[i - 2]
    print(dp[len(code)] % 1000000) # 결국 코드가 몇이냐보다 코드의 자리수에 따라 답이 결정됨
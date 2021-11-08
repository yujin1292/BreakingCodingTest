# 후위표기식1
# sys의 readline으로 받으면 작동되지 않음
# input()으로만 작동되는 이유가 궁금

import sys

# 1. 중위 표기식이 주어짐
infix_str = input()
prefix_str = '' # 최종 반환될 후위 표기식
op_stack = [] # 연산자 스택
priority = {'*':1, '/':1, "+":0, "-":0} #우선순위 Dict

# 2. 후위 표기식으로 변환
for char in '('+infix_str+')':

    # 2-1. char이 알파벳일 경우 그대로 추가
    if char.isalpha():
        prefix_str+=char

    # 2-2. )일 경우 추가
    elif char == '(':
        op_stack.append(char)

    # 2-3. )일 경우 (가 나타날 때 까지 pop
    elif char == ')':
        chk = op_stack.pop()
        while chk != '(':
            prefix_str += chk
            chk = op_stack.pop()

    # 2-4. 연산자만 스택에 추가
    else :
        while op_stack[-1] != '(' and priority[char] <= priority[op_stack[-1]]:
            prefix_str += op_stack.pop()
        op_stack.append(char)

# 3. 결과 출력
print(prefix_str)

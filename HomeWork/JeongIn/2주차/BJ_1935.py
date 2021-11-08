# 후위 표기식2
## 중위 표기법 : 일반적인 방식
## 후위 표기법 : 연산자가 피연산자 위데 위치하는 방법

# 1. 피연산자 개수, 후위 표기식, 각 피연산자에 대응하는 값
N = int(input())
postfix_str = input()
result_stack = []
nval_stack = []

# 각 피연산자에 대응하는 숫자를 스택에 추가
for _ in range(N):
    nval_stack.append(int(input()))

# 2. 연산자를 만나면 앞에 두 수를 연산
for c in postfix_str:
    if c.isupper():
        # 문자 -> 아스키 : ord
        # 알파벳 아스키코드 - 65 = 알파벳 순서에 맞는 인덱스가 나옴
        result_stack.append(nval_stack[ord(c) - 65])
    else :
        val_1 = result_stack.pop()
        val_2 = result_stack.pop()

        if c == "+":
            result_stack.append(val_1+val_2)
        if c == "-":
            result_stack.append(val_2-val_1)
        if c == "*":
            result_stack.append(val_1*val_2)
        if c == "/":
            result_stack.append(val_2/val_1)

# 3. 결과 출력
print("%.2f"%float(result_stack.pop()))
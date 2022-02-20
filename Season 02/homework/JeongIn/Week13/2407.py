# 조건 : nCm = n! / (m! *(n-m)!)

n, m = map(int, input().split())
factorial = [1,1,2] # 0,1,2일때 팩토리얼

for i in range(3, n+1):
    factorial.append(factorial[i-1]*i)

print(factorial[n]// (factorial[m] * factorial[n-m]))


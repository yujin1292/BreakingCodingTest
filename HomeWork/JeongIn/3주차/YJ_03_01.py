# Q1) N을 입력받고, N을 2진수로 나타냈을때 1의 개수를 구하여라. (toString 금지 ) ( 0<= N <= 800 )

N = int(input())
one_num = 0

# while N > 0 :
#     if N%2 == 1 :
#         one_num+=1
#     N = N // 2


while (N):
    # print(N)
    one_num+=(N&1) # 1010 & 0001 -> 0101 & 0001 -> ...
    N = N >> 1 # = N//2


print(one_num)
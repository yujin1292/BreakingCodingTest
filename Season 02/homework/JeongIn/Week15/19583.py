# 싸이버 개강 총회

import sys
input = sys.stdin.readline

# 입력
S, E, Q = input().split() # 시작 시간, 끝낸 시간, 스트리밍 끝낸 시간

S = int(S.replace(":",""))
E = int(E.replace(":",""))
Q = int(Q.replace(":",""))
cnt = 0
attend = set() # 시간 복잡도 상 set이 좋음(remove가 O(1))


while True :
    check = input()
    if len(check) < 2:
        # 입력이 엔터라면 출력 후 종료
        print(cnt)
        exit()
    time, name = check.split()
    time = int(time.replace(":",""))
    if time <= S:
        attend.add(name)
    if E <= time <= Q :
        if name in attend:
            cnt +=1
            attend.remove(name)


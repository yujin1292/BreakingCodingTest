import sys

input = sys.stdin.readline

N = int(input()) # 온라인 저지 회원의 수
member_list = [] # 회원 정보 리스트


for i in range(N):
     age, name = map(str, input().split())
     age = int(age)
     member_list.append((age, name))

member_list.sort(key=lambda x: x[0]) # 0번째 원소, age를 기준으로 정렬
for _, member in enumerate(member_list):
     print(member[0], member[1]) #age, name을 순서대로 출력
     # * enumerate 는 인덱스와 원소를 반환!
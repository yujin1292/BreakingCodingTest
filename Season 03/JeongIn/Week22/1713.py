# 후보 추천하기

import sys

input = sys.stdin.readline

# 사진틀의 개수
N = int(input())

# 전체 학생의 총 추천 횟수
recom_total = int(input())

# 추천받은 학생 번호
recom_nums = list(map(int, input().split(" ")))

# 사진틀 dictionary로 초기화
frame = dict()

for i in range(recom_total):
    # 이미 추천받은 경우
    if recom_nums[i] in frame:
        frame[recom_nums[i]][0] += 1 # 추천수를 1 증가

    else:
        # 사진틀이 남았을 경우 추가
        if len(frame) < N :
            frame[recom_nums[i]] = [1, i] # 몇 번째로 추천받았는지를 함께 추가

        # 비어있는 사진틀이 없을 경우 횟수가 가장 적은 학생 사진 삭제
        # 리스트 정렬 후 마지막 원소 삭제
        else :
            # 추천수, 추천받은 순서를 기준으로 오름차순 정렬
            # key값을 기준으로 정렬되며, x는 items 반환값을 의미
            del_frame = sorted(frame.items(), key = lambda x : (x[1][0], x[1][1]))
            del_key = del_frame[0][0] # 가장 추천수가 적고 먼저 추천받은 key 를 저장
            del(frame[del_key]) # 딕셔너리에서 해당 키 삭제
            frame[recom_nums[i]] = [1, i] # 새로 추천 받은 학생 번호 넣기

# key를 기준으로 사진틀 정렬
result_frame = sorted(frame.keys())
# 공백 분리 출력
print(' '.join(map(str, result_frame)))


// 1713번 후보 추천하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student {
    int num;
    int rcmd;
    int time;

    Student(int num, int rcmd, int time) {
        this.num = num;
        this.rcmd = rcmd;
        this.time = time;
    }
}

public class week22_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalRcmd = Integer.parseInt(br.readLine());

        ArrayList<Student> frame = new ArrayList<>();

        int time = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalRcmd; i++) {
            int stdNum = Integer.parseInt(st.nextToken());

            // 사진틀에 빈 자리가 있을 때
            if (frame.size() < N) {
                boolean isExist = false;

                // 추천된 학생이 이미 사진틀에 있을 때
                for (Student s : frame) {
                    if (s.num == stdNum) {
                        s.rcmd++;
                        isExist = true;
                        break;
                    }
                }

                if (isExist) continue;

                frame.add(new Student(stdNum, 1, time++));
            }

            // 사진틀에 빈 자리가 없을 때
            else {
                boolean isExist = false;

                // 추천된 학생이 이미 사진틀에 있을 때
                for (Student s : frame) {
                    if (s.num == stdNum) {
                        s.rcmd++;
                        isExist = true;
                        break;
                    }
                }

                if (isExist) continue;

                // 추천된 학생이 사진틀에 없는 학생일 때
                int minRcmd = 1000;
                int minTime = 1000;
                for (Student s : frame) {
                    if (s.rcmd < minRcmd) { // 추천수가 더 적은 사진으로 min 값 갱신
                        minRcmd = s.rcmd;
                        minTime = s.time;
                    }
                    else if (s.rcmd == minRcmd) {   // 추천수가 같을 경우 더 오래된 사진의 시간으로 갱신
                        if (s.time <= minTime) minTime = s.time;
                    }
                }

                for (Student s : frame) {
                    if (s.time == minTime) {    // 가장 오래된 사진을 지움
                        frame.remove(s);
                        break;
                    }
                }

                frame.add(new Student(stdNum, 1, time++));  // 새로 추천된 학생을 사진틀에 게시
            }
        }

        int[] result = new int[N];
        int idx = 0;
        for(Student s : frame) result[idx++] = s.num;

        Arrays.sort(result);    // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for(int n : result) {
            if (n != 0) sb.append(n).append(' ');   // 0이 출력되는 것을 방지
        }

        System.out.println(sb);
    }
}

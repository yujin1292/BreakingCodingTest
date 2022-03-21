import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week13_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 계단의 점수를 저장할 배열
        int[] stairs = new int[301];
        // 밟은 계단의 점수 합을 저장할 배열
        int[] score = new int[301];

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i ++)
            stairs[i] = Integer.parseInt(br.readLine());

        // 첫번째~세번째 계단의 값 계산
        score[1] = stairs[1];
        score[2] = stairs[1] + stairs[2];
        score[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        // 1. n-3번째 계단을 밟고 n-1번째 계단을 밟은 경우
        // 2. n-2번째 계단을 밟은 경우
        // 1과 2를 비교하여 더 큰 값에 현재 계단의 점수를 더함
        for (int i = 4; i <= n; i++)
            score[i] = Math.max(score[i-3] + stairs[i-1], score[i-2]) + stairs[i];

        System.out.println(score[n]);
    }
}

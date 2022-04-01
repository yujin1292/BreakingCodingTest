

// 1495번 기타리스트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class week20_1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] volDiff = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) volDiff[i] = Integer.parseInt(st.nextToken());

        int[] result = new int[M+1];
        Arrays.fill(result, -1);
        result[S] = 0;  // 0번째 곡의 볼륨은 S

        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (result[j] == i) {
                    int nextVol1 = j + volDiff[i];
                    int nextVol2 = j - volDiff[i];

                    if (nextVol1 >= 0 && nextVol1 <= M) list.add(nextVol1);
                    if (nextVol2 >= 0 && nextVol2 <= M) list.add(nextVol2);

                    // 바로 저장하면 이전 내용이 덮어쓰기 되므로 list에 담아줘야 함
//                    if (nextVol1 >= 0 && nextVol1 <= M) result[nextVol1] = i + 1;
//                    if (nextVol2 >= 0 && nextVol2 <= M) result[nextVol2] = i + 1;
                }
            }

            for (int v : list) result[v] = i + 1;   // i+1번째 곡의 볼륨은 v
        }

        int answer = -1;
        for (int i = 0; i < M+1; i++) {
            if (result[i] == N) answer = Math.max(answer, i);   // N번째 곡을 연주할 때 가장 큰 볼륨(가장 큰 인덱스) 출력
        }

        System.out.println(answer);
    }

}

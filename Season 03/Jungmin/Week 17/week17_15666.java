import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class week17_15666 {

    public static int N, M;
    public static int[] arr;
    public static Integer[] result; // 수열을 저장할 배열
    public static Set<String> hs = new LinkedHashSet<>();  // 수열을 저장할 set -> 중복되는 수열 방지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 값 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        arr = new int[N+1];
        result = new Integer[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(1, 0);
        for(Object answer: hs) System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        //  수열의 길이가 M이 되었을 때
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(' ');
            hs.add(sb.toString());  // String 형으로 수열을 set에 저장
            return;
        }

        // for문 시작점은 start
        for (int i = start; i <= N; i++) {
            result[depth] = arr[i]; // 수열의 원소 저장
            dfs(i, depth+1);
            // 중복 허용이므로 visited 배열은 필요 없음
        }
    }
}

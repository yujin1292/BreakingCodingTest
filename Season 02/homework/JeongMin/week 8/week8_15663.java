import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class week8_15663 {
    public static int[] numSet; // N개의 자연수를 저장할 배열
    public static int[] visited; // 노드를 방문했는지 확인 -> 중복 방지
    public static int[] result; // 하나의 수열을 저장할 배열
    public static Set<String> hs = new LinkedHashSet<>();  // 수열을 저장할 set -> 중복되는 수열 방지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 값 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        numSet = new int[N];
        visited = new int[N];
        result = new int[M];

        // N개의 자연수 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numSet[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numSet); // 미리 정렬하여 증가하는 순서로 출력되도록 함
        dfs(N, M, 0);
        for(String answer: hs) System.out.println(answer);
    }

    public static void dfs(int N, int M, int depth) {
        //  수열의 길이가 M이 되었을 때
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(' ');
            hs.add(sb.toString());  // String 형으로 수열을 set에 저장
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1; // 노드 방문 표시
                result[depth] = numSet[i]; // 수열의 원소 저장
                dfs(N, M, depth+1);
                visited[i] = 0; // dfs가 끝나면 방문 표시 제거
            }
        }
    }
}

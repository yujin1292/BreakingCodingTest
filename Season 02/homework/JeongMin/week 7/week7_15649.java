import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week7_15649 {
    public static int[] visited; // 노드를 방문했는지 확인 -> 중복 방지
    public static int[] result; // 수열을 저장할 배열
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 값 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        visited = new int[N+1];
        result = new int[M];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        //  수열의 길이가 M이 되었을 때
        if (depth == M) {
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(' '); // 출력
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1; // 노드 방문 표시
                result[depth] = i; // 수열의 원소 저장
                dfs(N, M, depth+1);
                visited[i] = 0; // dfs가 끝나면 방문 표시 제거
            }
        }
    }
}

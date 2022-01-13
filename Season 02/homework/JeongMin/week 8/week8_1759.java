import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class week8_1759 {
    public static String[] alpha;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        alpha = new String[C];
        visited = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);
        dfs(C, L, 0, 0);
    }

    public static void dfs(int C, int L, int start, int depth) {
        // 길이가 L이 되었을 때
        if (depth == L) {
            int con = 0, vow = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < C; i++) {
                // 뽑은 숫자만 출력
                if (visited[i] == 1) {
                    sb.append(alpha[i]);
                    // 자음, 모음 개수 체크
                    if (checkAlpha(alpha[i])) vow++;
                    else con++;
                }
            }
            // 자음이 2개 이상, 모음이 1개 이상이라면 출력
            if (con >= 2 && vow >= 1) System.out.println(sb);
            return;
        }

        for (int j = start; j < C; j++) {
            if(visited[j] == 0) {
                visited[j] = 1; // 노드 방문 표시
                dfs(C, L, j+1, depth+1);
                visited[j] = 0; // dfs가 끝나면 방문 표시 제거
            }
        }
    }

    // 자음, 모음 개수 체크를 위한 함수
    public static boolean checkAlpha(String a) {
        if (a.equals("a") || a.equals("e") || a.equals("i") || a.equals("o") || a.equals("u")) return true;
        else return false;
    }
}

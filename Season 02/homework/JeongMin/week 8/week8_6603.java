import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week8_6603 {
    public static int[] setS;
    public static int[] visited; // 노드를 방문했는지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // k, 집합 S 입력 받기
        while(true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            // 배열 초기화
            setS = new int[k];
            visited = new int[k];

            for (int i = 0; i < k; i++) {
                setS[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }

    }

    public static void dfs(int start, int depth) {
        // 숫자 6개를 뽑았을 때
        if (depth == 6) {
            for(int i = 0; i < setS.length; i++) {
                // 뽑은 숫자만 출력
                if (visited[i] == 1) System.out.print(setS[i] + " ");
            }
            System.out.println();
        }

        for (int j = start; j < setS.length; j++) {
            if(visited[j] == 0) {
                visited[j] = 1; // 노드 방문 표시
                dfs(j+1, depth+1);
                visited[j] = 0; // dfs가 끝나면 방문 표시 제거
            }
        }
    }
}

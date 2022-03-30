import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class week19_1976 {

    public static int N, M;
//    public static ArrayList<Integer>[] graph;
    public static int[][] map;
    public static int[] plan, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

//        graph = new ArrayList[N];
//        for (int i = 0; i < N; i++) {
//            graph[i] = new ArrayList<>();
//        }

//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                if (Integer.parseInt(st.nextToken()) == 1) graph[i].add(j);
//            }
//        }

        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N+1];

        plan = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) plan[i] = Integer.parseInt(st.nextToken());

        // 여행 계획의 첫번째 도시부터 방문
        dfs(plan[1]);

        // 여행 계획의 모든 도시를 방문했는지 확인
        boolean isPossible = true;
        for (int i = 1; i <= M; i++) {
            if (visited[plan[i]] == 0) {
                isPossible = false;
                break;
            }
        }


        if (isPossible) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void dfs(int node) {

        visited[node] = 1;

        for (int i = 1; i <= N; i++) {

            // 이전에 방문하지 않은 도시이고
            // 갈 수 있는 도시라면 dfs
            if ((visited[i] == 0) && (map[node][i] == 1)) dfs(i);

        }

//        for (int i = 0; i < N; i++) {
//            int next = graph[node].get(i);
//
//            if (visited[next] == 0) dfs(next);
//
//        }
    }
}

// 9372 상근이의 여행

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week20_9372 {

    public static int N, M;
    public static int[][] graph;
    public static int[] visited;
    public static int result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N][N];
            visited = new int[N];

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                // 왕복 비행기 
                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            result = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 방문하지 않은 국가이고 왕복 비행기가 존재한다면 방문
                    if (graph[j][k] == 1 && visited[j] == 0) dfs(j);
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int j) {

        visited[j] = 1;

        for (int i = 0; i < N; i++) {
            if (graph[j][i] == 1 && visited[i] == 0) {
                result++;   // 타야 하는 비행기 개수 갱신
                dfs(i);
            }
        }
    }
}

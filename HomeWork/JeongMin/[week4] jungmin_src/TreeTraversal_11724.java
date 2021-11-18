import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] graph = new int[1001][1001];
        int[] visited = new int[1001];
        int count = 0;

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i] != 1) {
                dfs(i, N, graph, visited);
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);
    }

    public static void dfs(int i, int N, int[][] graph, int[] visited) {
        if (visited[i] == 1) return;
        else {
            visited[i] = 1;
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 1) dfs(j, N, graph, visited);
            }
        }
    }
}

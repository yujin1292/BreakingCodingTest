

// 1707번 이분 그래프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class week21_1707 {

    public static int V, E;
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for (int j = 0; j <= V; j++) graph[j] = new ArrayList<>();

            visited = new int[V+1];

            isBipartite = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for (int j = 1; j <= V; j++) {
                if (!isBipartite) break;

                if (visited[j] == 0) dfs(j, 1);
            }

            sb.append(isBipartite ? "YES" : "NO").append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int node, int state) {

        visited[node] = state;

        for (int adjNode : graph[node]) {
            if (visited[adjNode] == state) {
                isBipartite = false;
                return;
            }

            else if (visited[adjNode] == 0) dfs(adjNode, -state);
        }
    }
}

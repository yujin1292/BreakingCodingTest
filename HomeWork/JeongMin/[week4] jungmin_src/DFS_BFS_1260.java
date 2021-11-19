import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int[][] graph = new int[1001][1001];
        LinkedList<Integer>[] list = new LinkedList[N+1];
        int[] visited = new int[N+1];

        for(int i = 0; i <= N; i++) list[i] = new LinkedList<Integer>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 0; i < N+1; i++) Collections.sort(list[i]);

        dfs(start, N, graph, visited);
        for(int i = 0; i < visited.length; i++) visited[i] = 0;
        System.out.println();
        bfs(start, N, list, visited);
    }

    public static void dfs(int i, int N, int[][] graph, int[] visited) {
        StringBuilder sb = new StringBuilder();
        if (visited[i] == 1) return;
        else {
            visited[i] = 1;
            sb.append(i).append(" ");
            System.out.print(sb);
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 1) dfs(j, N, graph, visited);
            }
        }
    }

    public static void bfs(int i, int N, LinkedList<Integer>[] list, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        visited[i] = 1;
        queue.offer(i);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int j = 0; j < list[cur].size(); j++) {
                int next = list[cur].get(j);
                if (visited[next] == 1) continue;
                queue.offer(next);
                visited[next] = 1;
            }
        }

        System.out.print(sb);
    }
}

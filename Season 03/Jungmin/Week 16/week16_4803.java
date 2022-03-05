import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class week16_4803 {
    public static List<Integer>[] graph;
    public static int[] visited;
    public static int n, m;
    public static boolean isCycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int caseNum = 0;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;
            caseNum++;

            graph = new ArrayList[n+1];
            visited = new int[n+1];

            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int tree = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    isCycle = false;
                    dfs(i, 0);
                    if (!isCycle) tree++;   // 사이클이 존재하지 않을 때에만 트리 개수를 카운트
                }
            }

            if (tree == 0) sb.append("Case " + caseNum + ": No trees.").append('\n');
            else if (tree == 1) sb.append("Case " + caseNum + ": There is one tree.").append('\n');
            else sb.append("Case " + caseNum + ": A forest of " + tree + " trees.").append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int i, int prev) {
        visited[i] = 1;

        for (int next : graph[i]) {
            if (next == prev) continue; // 이전 노드로 되돌아가지 않음
            if (visited[next] == 1) {   // 방문했던 노드라면 사이클이 존재하는 것
                isCycle = true;
                return;
            }
            if (visited[next] == 0) dfs(next, i);
        }
    }
}

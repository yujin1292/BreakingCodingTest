

// 5107번 마니또


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class week23_5107 {

    public static int N, cnt;
    public static HashMap<String, Integer> map;
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            cnt = 0;

            map = new HashMap<>();
            graph = new int[N][N];
            visited = new boolean[N];
            int idx = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                // map에 없는 이름이면 새로 추가
                if (!map.containsKey(s1)) map.put(s1, idx++);
                if (!map.containsKey(s2)) map.put(s2, idx++);

                int p1 = map.get(s1);
                int p2 = map.get(s2);
                graph[p1][p2] = 1;  // 연결고리 표시
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    for (int j = 0; j < N; j++) {
                        if (graph[i][j] == 1 && !visited[j]) dfs(j);
                    }
                }
            }

            sb.append(t + " " + cnt).append('\n');
            t++;
        }

        System.out.println(sb);
    }

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 0; i < N; i++) {
            if (graph[x][i] == 1) {
                if (visited[i]) cnt++;  // 이미 방문한 노드라면 사이클이 있는 것
                else dfs(i);
                break;
            }
        }
    }
}

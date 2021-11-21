import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus_2606 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cNum = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[][] graph = new int[101][101];
        int[] visited = new int[101];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            graph[c1][c2] = graph[c2][c1] = 1;
        }

        SearchVirus(1, cNum, graph, visited);

        sb.append(--count);
        System.out.println(sb);
    }

    public static void SearchVirus(int i, int cNum, int[][] graph, int[] visited) {
        if (visited[i] == 1) return;
        else {
            visited[i] = 1;
            count++;
            for(int j = 1; j <= cNum; j++) {
                if(graph[i][j] == 1) SearchVirus(j, cNum, graph, visited);
            }
        }
    }
}

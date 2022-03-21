import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week18_2252 {

    public static int N, M;
    public static int[] inDegree;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b]++;  // 진입차수 갱신
        }

        System.out.println(topologySort());
    }

    public static StringBuilder topologySort() {

        StringBuilder sb = new StringBuilder();

        int[] result = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) queue.offer(i);

        // n개의 노드를 방문하여 정렬
        for (int i = 1; i <= N; i++) {
            // n개를 방문하기 전 큐가 비면 사이클 발생
            if (queue.isEmpty()) return sb;

            int tmp = queue.poll();
            result[i] = tmp;

            for (int j = 0; j < graph.get(tmp).size(); j++) {
                int adj = (graph.get(tmp)).get(j);  // 연결된 노드를 찾음
                if (--inDegree[adj] == 0) queue.offer(adj); // 연결 노드의 간선 제거 + 새로 진입차수가 0이 된 노드를 큐에 삽입
            }
        }

        for (int i = 1; i <= N; i++) sb.append(result[i]).append(" ");

        return sb;
    }
}

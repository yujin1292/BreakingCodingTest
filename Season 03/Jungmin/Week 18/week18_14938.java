import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int idx;
    int cost;

    // 생성자
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class week18_14938 {

    public static int n, m, r;
    public static int[] item;
    public static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) item[i] = Integer.parseInt(st.nextToken());

        // 1. 인접리스트를 이용한 그래프 초기화
        graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            // a로 부터 b로 가는 비용은 cost
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        // 시작 지점에 따라서 습득 가능한 아이템 개수의 최댓값을 찾음
        int ans = -1;
        for (int i = 1; i < n + 1; i++) ans = Math.max(ans, dijkstra(i));

        System.out.println(ans);
    }

    public static int dijkstra(int start) {
        // 방문 여부를 확인할 boolean 배열
        boolean[] visited = new boolean[n + 1];
        // start 노드부터 end 노드 까지의 최소 거리를 저장
        int[] dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            // 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        // 다익스트라 알고리즘 진행
        for (int i = 0; i < n; i++) {
            // 현재 거리 비용 중 최소인 지점을 선택

            // 해당 노드가 가지고 있는 현재 비용
            int nodeValue = Integer.MAX_VALUE;
            // 해당 노드의 인덱스(번호)
            int nodeIdx = 0;

            for (int j = 1; j < n + 1; j++) {
                // 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }

            // 최종 선택된 노드를 방문처리
            visited[nodeIdx] = true;

            // 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                // 인접 노드를 선택
                Node adjNode = graph.get(nodeIdx).get(j);
                // 인접 노드가 현재 가지는 최소 비용과
                // 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        // 수색범위 내일 경우 습득 가능한 아이템 개수를 더함
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                result += item[i];
            }
        }

        return result;
    }
}

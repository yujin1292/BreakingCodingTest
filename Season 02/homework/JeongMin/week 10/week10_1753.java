import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 도착 지점과, 도착지점으로 가는 비용을 의미하는 클래스
class Node {
    int idx;
    int cost;

    // 생성자
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class week10_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 노드와 간선의 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 출발지점
        int start = Integer.parseInt(br.readLine());

        // 인접리스트를 이용한 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        // 노드의 번호가 1부터 시작하므로, 0번 인덱스 부분을 임의로 만들어 놓기만 한다.
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 값을 넣는다.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // a로 부터 b로 가는 값은 cost
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];    //start 노드부터 end 노드 까지의 최소 거리 저장

        for (int i = 0; i < V + 1; i++) {
            // 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정
            dist[i] = Integer.MAX_VALUE;
        }

        // 출발 지점의 비용은 0으로 시작
        dist[start] = 0;

        // 모든 노드을 방문하면 종료 -> 노드의 개수 만큼만 반복
        for (int i = 0; i < V; i++) {
            // 현재 거리 비용 중 최소인 지점을 선택
            int nodeValue = Integer.MAX_VALUE;  // 해당 노드가 가지고 있는 현재 비용
            int nodeIdx = 0;    // 해당 노드의 인덱스(번호)

            for (int j = 1; j < V + 1; j++) {
                // 방문하지 않은 노드
                // 현재 모든 거리비용 중 최솟값
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

        // 최종 비용을 출력
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}

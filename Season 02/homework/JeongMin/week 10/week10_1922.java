import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    // 정렬을 위한 비교함수 정의
    @Override
    public int compareTo(Edge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}

public class week10_1922 {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;

    // 집합 합치기
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 같은 부모 노드가 아닐 때
        if(x != y)
            parent[y] = x;
    }

    // 어떤 집합에 포함되어 있는지 찾기
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 같은 부모 노드를 갖고 있는지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 가중치 정보 받아오기
        edgeList = new ArrayList<Edge>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(n1, n2, cost));
        }

        // 부모 노드 정보 배열 초기화
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 정렬
        Collections.sort(edgeList);

        int sum = 0;
        for(int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            // 같은 부모 노드가 아닐 경우
            if(!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(sum);
    }
}


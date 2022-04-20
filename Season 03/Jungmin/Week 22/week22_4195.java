

// 4195번 친구 네트워크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class week22_4195 {

    public static int F;

    public static int[] parent;
    public static int[] dist;
    public static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[F*2];
            dist = new int[F*2];

            for (int j = 0; j < F*2; j++) {
                parent[j] = j;
                dist[j] = 1;
            }

            map = new HashMap<>();
            int idx = 0;

            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                // map에 없는 이름이면 새로 추가
                if (!map.containsKey(s1)) map.put(s1, idx++);
                if (!map.containsKey(s2)) map.put(s2, idx++);

                sb.append(union(map.get(s1), map.get(s2))).append('\n');
                }
            }

            System.out.println(sb);
        }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
            dist[x] += dist[y]; // 부모까지의 거리를 더함
        }

        return dist[x];
    }

    public static int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}

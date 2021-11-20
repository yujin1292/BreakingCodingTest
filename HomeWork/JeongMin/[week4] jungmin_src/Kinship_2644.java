import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 왜 틀렸을까요
public class Kinship_2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] list = new LinkedList[N+1];
        int[] visited = new int[N+1];

        for(int i = 0; i <= N; i++) list[i] = new LinkedList<Integer>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 0; i < N+1; i++) Collections.sort(list[i]);

        bfs(p1, p2, list, visited);
    }

    public static void bfs(int start, int end, LinkedList<Integer>[] list, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int distance = 0, flag = 0;

        visited[start] = 1;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int j = 0; j < list[cur].size(); j++) {
                int next = list[cur].get(j);
                if (next == end) {
                    flag = 1;
                    break;
                }
                if (visited[next] == 1) continue;
                queue.offer(next);
                visited[next] = 1;
            }
            distance++;
            if (flag == 1) break;
        }

        if(flag == 0) distance = -1;
        System.out.print(distance);
    }
}

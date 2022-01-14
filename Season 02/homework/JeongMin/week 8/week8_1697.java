import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week8_1697 {
    // 노드를 방문했는지 확인하면서 몇초 경과했는지 저장
    public static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, K 위치 값 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) System.out.println(0);
        else bfs(N, K);
    }

    public static void bfs(int start, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1; // 처음 시작 지점을 1초로 두고 시작

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                // 다음 갈 곳이 목적지일 경우
                if (next == K) {
                    // count를 출력하고 return
                    System.out.println(visited[cur]);
                    return;
                }

                // 다음 갈 곳이 아직 방문하지 않은 곳일 경우
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[cur] + 1; // 초 계산
                }
            }
        }
    }
}

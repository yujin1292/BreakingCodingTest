import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class study04_2644 {

    public static int N, M;
    public static int start, end;
    public static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        visited = new int[101];


        for (int i = 0; i < N+1; i++) {
            relation.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        System.out.println(calculateDegreeOfKinship());
    }

    public static int calculateDegreeOfKinship() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) {   // 입력에서 요구한 사람의 촌수
                return visited[end];
            }

            for (int i = 0; i < relation.get(cur).size(); i++) {

                int next = relation.get(cur).get(i);

                if (visited[next] == 0) {   // 촌수 계산
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;  // 친척 관계가 없을 경우
    }
}

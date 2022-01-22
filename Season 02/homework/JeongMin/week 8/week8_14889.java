import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week8_14889 {
    public static int[][] power;
    public static int[] visited;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N값 받아서 배열 초기화
        int N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, N,0);

        System.out.println(min);
    }

    public static void dfs(int s, int N, int depth) {
        //  수열의 길이가 N/2이 되었을 때
        if (depth == N/2) {
            calcDiff(N);
            return;
        }

        for (int i = s; i < N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1; // 노드 방문 표시
                dfs(i+1, N,depth+1);
                visited[i] = 0; // dfs가 끝나면 방문 표시 제거
            }
        }
    }

    // start와 link 차이의 최소값 계산
    public static void calcDiff(int N) {
        int start = 0, link = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                // 방문한 node는 start 팀으로, 방문하지 않은 node는 link 팀으로 나누기
                if (visited[i] == 1 && visited[j] == 1) {
                    start += power[i][j];
                    start += power[j][i];
                }
                else if (visited[i] == 0 && visited[j] == 0) {
                    link += power[i][j];
                    link += power[j][i];
                }
            }
        }

        // 최소값 계산
        int temp = Math.abs(start - link);
        // 0이면 바로 종료
        if (temp == 0) {
            System.out.println(temp);
            System.exit(0);
        }
        if (temp <= min) min = temp;
    }
}

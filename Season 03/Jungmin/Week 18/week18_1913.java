import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week18_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int num = N*N;
        int start1 = 0;
        int start2 = 1;
        int end1 = N-1;
        int end2 = N-2;
        while(num != 1) {
            // 가장 왼쪽 줄 위에서 아래로 채우기
            for (int i = start1; i <= end2; i++) {
                if (num == 1) break;
                arr[i][start1] = num;
                num--;
            }

            // 가장 아래쪽 줄 왼쪽에서 오른쪽으로 채우기
            for (int i = start1; i <= end2; i++) {
                if (num == 1) break;
                arr[end1][i] = num;
                num--;
            }

            // 가장 오른쪽 줄 아래에서 위로 채우기
            for (int i = end1; i >= start2; i--) {
                if (num == 1) break;
                arr[i][end1] = num;
                num--;
            }

            // 가장 위쪽 줄 오른쪽에서 왼쪽으로 채우기
            for (int i = end1; i >= start2; i--) {
                if (num == 1) break;
                arr[start1][i] = num;
                num--;
            }

            start1++;
            start2++;
            end1--;
            end2--;
        }

        arr[N/2][N/2] = 1;

        StringBuilder sb = new StringBuilder();
        int targetX = -1, targetY = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                // target의 좌표 저장
                if (arr[i][j] == target) {
                    targetX = i+1;
                    targetY = j+1;
                }
            }
            sb.append('\n');
        }

        sb.append(targetX).append(" ").append(targetY);
        System.out.println(sb);
    }
}

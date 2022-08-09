import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study03_1182 {

    public static int N, S;
    public static int[] numArr;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        getPartialSum(0, 0);
        if (S == 0) result--;   // 공집합일 경우 sum이 0이 되는데, 이는 부분수열의 합이 S인 경우에 해당하지 않으므로 S가 0일 때는 결과값에서 1을 빼줘야 함
        System.out.println(result);
    }

    public static void getPartialSum(int sum, int depth) {

        if (depth == N) {
            if (sum == S) { // 부분수열의 합이 S라면
                result++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                getPartialSum(sum + numArr[depth], depth + 1);  // numArr[depth]를 선택
            } else {
                getPartialSum(sum, depth + 1);  //// numArr[depth]를 선택 X
            }
        }
    }
}

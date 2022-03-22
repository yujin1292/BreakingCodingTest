import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week17_14888 {

    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static int[] numArr, opArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new int[N];    // 계산할 수를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numArr[i] = Integer.parseInt(st.nextToken());

        opArr = new int[4]; // 연산자 개수를 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) opArr[i] = Integer.parseInt(st.nextToken());

        dfs(1, numArr[0] );

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int opCnt, int result) {

        if (opCnt == N) {   // 연산자를 N-1개 사용했을 때 -> 수식이 완성됐을 때
            max = Math.max(max, result);    // 최대, 최소값 갱신
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opArr[i] > 0) { // 사용할 수 있는 연산자라면
                opArr[i]--; // 연산자를 사용했으므로 1개 감소시킴

                if (i == 0) dfs(opCnt+1, result+numArr[opCnt]);
                else if (i == 1) dfs(opCnt+1, result-numArr[opCnt]);
                else if (i == 2) dfs(opCnt+1, result*numArr[opCnt]);
                else if (i == 3) dfs(opCnt+1, result/numArr[opCnt]);

                opArr[i]++; // dfs 후 연산자 개수를 원래대로 돌림
            }
        }
    }
}

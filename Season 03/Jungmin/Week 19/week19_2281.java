import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class week19_2281 {

    public static int n, m;
    public static int[] name;
    public static int[][] dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        name = new int[n];
        for (int i = 0; i < n; i++)
            name[i] = Integer.parseInt(br.readLine());

        dpArr = new int[1010][1010];
        for (int i = 0; i < dpArr.length; i++)
            Arrays.fill(dpArr[i], -1);

        System.out.println(dp(name[0]+1, 1));

    }

    public static int dp(int cur, int nameIdx) {
        if (nameIdx == n) return 0;

        if (dpArr[cur][nameIdx] != -1) return dpArr[cur][nameIdx];

        // 다음 줄에 이름 작성
        int left = m - cur + 1;
        int result = dp(name[nameIdx]+1, nameIdx+1) + left*left;

        // 현재 줄에 이어서 이름 작성
        if (cur + name[nameIdx] <= m)
            result = Math.min(result, dp(cur+name[nameIdx]+1, nameIdx+1));

        return dpArr[cur][nameIdx] = result;
    }
}

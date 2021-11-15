import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) nArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int result = binarySearch(nArr, 0, nArr.length - 1, x);
            if (result >= 0) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] nArr, int start, int end, int x) {
        if (start >= end) return (nArr[start] == x) ? start : -1;

        int mid = (start + end) / 2;

        if (x == nArr[mid]) return mid;
        else if (nArr[mid] >= x) return binarySearch(nArr, start, mid-1, x);
        else return binarySearch(nArr, mid+1, end, x);
    }
}

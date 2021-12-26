import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTrees_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long max = 0;

        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i];
        }

        long result = binarySearch(0, max, trees, m);
        sb.append(result).append('\n');
        System.out.println(sb);
    }

    public static long binarySearch(long start, long end, long[] trees, long m) {
        long mid = (start + end) / 2;

        if (start > end) return end;

        if (cut(mid, trees) < m) return binarySearch(start, mid-1, trees, m);
        else return binarySearch(mid+1, end, trees, m);
    }

    public static long cut(long h, long[] trees) {
        long sum = 0;

        for(int i = 0; i < trees.length; i++) {
            long rest = trees[i] - h;
            if (rest > 0) sum += rest;
        }

        return sum;
    }
}

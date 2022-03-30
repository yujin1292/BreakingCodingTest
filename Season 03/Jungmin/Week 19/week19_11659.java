import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week19_11659 {

    public static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1]; // 주어진 수를 담을 배열
        sum = new int[N+1]; // 주어진 수에 대한 구간합을 담을 배열
//        tree = new int[arr.length*4];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i]; // 구간합을 구함
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(sum[e]-sum[s-1]).append('\n');
        }

        System.out.println(sb);

//
//        init(0, arr.length-1, 1);
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            sb.append(sum(0, arr.length-1, 1,
//                    Integer.parseInt(st.nextToken())-1,
//                    Integer.parseInt(st.nextToken())-1));
//            sb.append('\n');
//        }
//
//        System.out.println(sb);
    }

//    public static long init(int start, int end, int node) {
//        if (start == end) return tree[node] = arr[start];
//
//        int mid = (start+end)/2;
//        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
//    }
//
//    public static long sum(int start, int end, int node, int left, int right) {
//        if (left > end || right < start) return 0;
//
//        if (left <= start && end <= right) return tree[node];
//
//        int mid = (start+end)/2;
//        return tree[node] = sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
//    }
}

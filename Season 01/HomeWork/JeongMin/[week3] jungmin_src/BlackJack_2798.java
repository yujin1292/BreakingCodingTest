import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        BlackJack(m, arr);
    }

    public static void BlackJack(int m, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum >= max && sum <= m) max = sum;
                }
            }
        }

        sb.append(max).append('\n');
        System.out.println(sb);
    }
}

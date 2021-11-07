import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sort_10989 {
    public static void main(String[] args) throws IOException {
        int n;
        int[] arr = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) arr[Integer.parseInt((br.readLine()))]++;

        for (int i = 1; i < 10001; i++) {
            while(arr[i] > 0) {
                sb.append(i).append('\n');
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}

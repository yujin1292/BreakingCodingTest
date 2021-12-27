import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factor_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        factor(n);
    }

    public static void factor(int n) {
        StringBuilder sb = new StringBuilder();
        int sqrtn = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrtn; i++) {
            while(n % i == 0) {
                n /= i;
                sb.append(i).append('\n');
            }
        }

        if (n > 1) sb.append(n).append('\n');

        System.out.println(sb);
    }
}

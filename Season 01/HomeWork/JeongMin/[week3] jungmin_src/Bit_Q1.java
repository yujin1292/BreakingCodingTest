import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bit_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] DecimalToBinary = new int[n];
        int idx = 0, count = 0;

        while(n != 0) {
            DecimalToBinary[idx] = n % 2;
            if (DecimalToBinary[idx] == 1) count++;
            n /= 2;
            idx++;
        }

        sb.append(count);
        System.out.println(sb);
    }
}

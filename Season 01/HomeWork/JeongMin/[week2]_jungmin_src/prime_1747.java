import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prime_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        while(true) {
            if (checkIsPrime(num) && checkIsPalindrome(num)) break;
            else num++;
        }

        sb.append(num).append('\n');
        System.out.println(sb);
    }

    public static boolean checkIsPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num %2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static boolean checkIsPalindrome(int num) {
        String s = num + "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }

        return true;
    }
}

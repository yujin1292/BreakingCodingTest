import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week12_2011 {
    // 다이나믹 프로그래밍을 위한 배열
    // n일 경우의 값을 저장 -> 구하지 않았다면 0
    public static int d[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n값 받아오기
        String n = br.readLine();
        if (n.charAt(0) == '0') {
            System.out.println("0");
            return;
        }

        d = new int[n.length()+1];
        d[0] = d[1] = 1;
        for (int i = 2; i <= n.length(); i++) {
            char cur = n.charAt(i-1);
            char prev = n.charAt(i-2);

            // 현재 문자가 0이고
            if (cur == '0') {
                // 바로 앞 문자가 1 또는 2일 경우 -> 옳은 문자열
                if (prev == '1' || prev == '2')
                    d[i] = d[i-2] % 1000000;
                else break;
            }
            else {
                // 앞 문자가 0일 경우
                if (prev == '0')
                    // '0n'은 경우의 수에 포함될 수 없으므로 이전 경우의 수와 같음
                    d[i] = d[i-1] % 1000000;
                else {
                    int checkNum = Integer.parseInt(String.valueOf(prev + "" + cur));
                    // 앞 문자와 현재 문자를 이었을 때 26을 넘는다면
                    if (checkNum > 26)
                        // 바로 전 경우의 수와 같음
                        d[i] = d[i-1] % 1000000;
                    else
                        // i-1번째 경우의 수와 i-2번째 경우의 수를 더함
                        d[i] = (d[i-1] + d[i-2]) % 1000000;
                }
            }
        }

        System.out.println(d[n.length()]);
    }
}

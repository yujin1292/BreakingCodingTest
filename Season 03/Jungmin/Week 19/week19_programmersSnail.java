import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week19_programmersSnail {

    public static int n, cnt = 1;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        result = new int[n*(n+1)/2 + 1];

        Snail(1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n*(n+1)/2 + 1; i++) sb.append(result[i]).append(" ");

        System.out.println(sb);
    }

    public static void Snail(int start, int size) {

        if (cnt > n*(n+1)/2 || size == 0) return;

        if (size == 1) {
            result[start] = cnt;
            cnt++;
        }

        else if (size == 2) {
            for (int i = 0; i < 3; i++) {
                result[start] = cnt;
                start++;
                cnt++;
            }
        }

        else if (size >= 3) {
            int dir = 0;
            int last = -1;
            while (dir < 3) {
                int limit = size*(size+1)/2;
                if (dir == 0) {
                    int idx = 0;
                    for (int i = start; i <= limit; i += idx) {
                        result[i] = cnt;
                        idx++;
                        cnt++;
                        last = i;
                    }
                } else if (dir == 1) {
                    for (int i = last+1; i < limit; i++) {
                        result[i] = cnt;
                        cnt++;
                        last = i;
                    }
                } else {
                    int idx = size+1;
                    for (int i = limit; i >= start+2; i -= idx) {
                        result[i] = cnt;
                        System.out.println("result[" + i + "] = " + result[i]);
                        idx--;
                        cnt++;
                    }
                }

                dir++;
            }
            Snail(start + 4, size - 3);
        }
    }
}

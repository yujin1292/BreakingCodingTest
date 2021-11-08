import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Josephus_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Josephus(n, k);
    }

    public static void Josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append('<');

        for(int i = 1; i <= n; i++) queue.add(i);

        while(!queue.isEmpty()) {
            for(int j = 1; j <= k; j++) {
                if (j == k) sb.append(queue.poll()).append(", ");
                else queue.add(queue.poll());
            }
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append('>').append('\n');

        System.out.println(sb);
    }
}

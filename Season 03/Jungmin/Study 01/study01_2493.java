import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
    int num;    // 탑의 순서
    int height; // 탑의 높이

    public Tower(int num ,int height) {
        this.num = num;
        this.height = height;
    }
}

public class study01_2493 {

    public static int N;
    public static Stack<Tower> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        sb.append("0").append(" ");

        int num = 1;
        st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        Tower tower = new Tower(num++, height);
        stack.push(tower);

        for (int i = 1; i < N; i++) {
            int nextH = Integer.parseInt(st.nextToken());

            while (stack.size() > 0 && nextH > stack.peek().height) {   // 신호를 수신할 수 있는 탑이 나올 때까지 pop
                stack.pop();
            }

            if (stack.size() == 0) {    // 앞에 신호를 수신할 수 있는 탑이 없을 경우
                sb.append("0").append(" ");
            } else {
                sb.append(stack.peek().num).append(" ");
            }

            Tower nextTower = new Tower(num++, nextH);
            stack.push(nextTower);
        }


        System.out.println(sb);
    }
}

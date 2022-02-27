import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class week15_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) stack.pop();  // 0일 경우 가장 최근 쓴 수를 삭제
            else stack.push(tmp);   // 0이 아니면 해당 수를 push
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();  // stack에 남은 수의 합을 구함
        }

        System.out.println(result);
    }
}

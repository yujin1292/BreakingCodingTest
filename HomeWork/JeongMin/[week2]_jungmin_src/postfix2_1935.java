import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfix2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String s;
        int n;

        n = Integer.parseInt(br.readLine());
        double[] num = new double[n];

        s = br.readLine();
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());
        translateIntoInfix(s, num);
    }

    public static void translateIntoInfix(String s, double[] num) {
        Stack<Double> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                idx = s.charAt(i) - 'A';
                stack.push(num[idx]);
            } else if (s.charAt(i) == '+') {
                double tmp = stack.pop() + stack.pop();
                stack.push(tmp);
            } else if (s.charAt(i) == '-') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2-tmp1);
            } else if (s.charAt(i) == '*') {
                double tmp = stack.pop() * stack.pop();
                stack.push(tmp);
            } else if (s.charAt(i) == '/') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2/tmp1);
            }
        }

        if (!stack.empty()) sb.append(String.format("%.2f", stack.pop())).append('\n');

        System.out.println(sb);
    }
}

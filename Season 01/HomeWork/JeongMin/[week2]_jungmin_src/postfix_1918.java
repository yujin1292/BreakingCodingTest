import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfix_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String s;

        s = br.readLine();
        translateIntoPostfix(s);
    }

    public static void translateIntoPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append(s.charAt(i));
            } else {
                if (stack.empty() || s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    while (!stack.empty()) {
                        if (stack.peek().equals('(')) {
                            stack.pop();
                            break;
                        }
                        sb.append(stack.pop());
                    }
                } else {
                    while (!stack.empty() && priority(stack.peek()) >= priority(s.charAt(i))) sb.append(stack.pop());
                    stack.push(s.charAt(i));
                }
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        sb.append('\n');
        System.out.println(sb);
    }

    public static int priority(Character c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else return 0;
    }
}

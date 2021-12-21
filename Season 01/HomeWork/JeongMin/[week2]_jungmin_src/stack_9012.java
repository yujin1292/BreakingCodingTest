import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int n;

        n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if (checkParenthesis(arr[i])) arr[i] = "YES";
            else arr[i] = "NO";
        }

        for(String s : arr) sb.append(s).append('\n');

        System.out.println(sb);
    }

    public static boolean checkParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.empty()) return false;
                if (stack.peek().equals('(')) stack.pop();
                else return false;
            }
            else if (s.charAt(i) == '(') stack.push(s.charAt(i));
        }
        if (stack.empty()) return true;
        else return false;
    }
}

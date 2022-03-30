import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week19_2290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while(cnt <= 2*s+3) {
            // 가장 윗줄에 첫번째 "-" 채우기
            if (cnt == 1) {
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) == '1' || n.charAt(i) == '4') {
                        for (int j = 0; j < s+2; j++) sb.append(" ");
                    }
                    else {
                        sb.append(" ");
                        for (int j = 0; j < s; j++) sb.append("-");
                        sb.append(" ");
                    }
                    sb.append(" "); // 숫자 사이 공백
                }
            }
            // 윗줄 이후 s만큼 "|" 채우기
            else if (cnt > 1 && cnt < s+2) {
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) == '1' || n.charAt(i) == '2' || n.charAt(i) == '3' || n.charAt(i) == '7') {
                        for (int j = 0; j < s+1; j++) sb.append(" ");
                        sb.append("|");
                    }
                    else if (n.charAt(i) == '5' || n.charAt(i) == '6'){
                        sb.append("|");
                        for (int j = 0; j < s+1; j++) sb.append(" ");
                    }
                    else {
                        sb.append("|");
                        for (int j = 0; j < s; j++) sb.append(" ");
                        sb.append("|");
                    }
                    sb.append(" "); // 숫자 사이 공백
                }
            }
            // 두번째 "-" 채우기 (숫자의 가운데)
            else if (cnt == s+2) {
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) == '1' || n.charAt(i) == '7' || n.charAt(i) == '0') {
                        for (int j = 0; j < s+2; j++) sb.append(" ");
                    }
                    else {
                        sb.append(" ");
                        for (int j = 0; j < s; j++) sb.append("-");
                        sb.append(" ");
                    }
                    sb.append(" "); // 숫자 사이 공백
                }
            }
            // 두번째 "|" 채우기 (숫자의 가운데 기준 아래 부분)
            else if (cnt > s+2 && cnt < 2*s+3) {
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) == '2') {
                        sb.append("|");
                        for (int j = 0; j < s+1; j++) sb.append(" ");
                    }
                    else if (n.charAt(i) == '6' || n.charAt(i) == '8' || n.charAt(i) == '0'){
                        sb.append("|");
                        for (int j = 0; j < s; j++) sb.append(" ");
                        sb.append("|");
                    }
                    else {
                        for (int j = 0; j < s+1; j++) sb.append(" ");
                        sb.append("|");
                    }
                    sb.append(" "); // 숫자 사이 공백
                }
            }
            // 숫자의 가장 아래 부분 "-" 채우기
            else if (cnt == 2*s+3) {
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) == '1' || n.charAt(i) == '4' || n.charAt(i) == '7') {
                        for (int j = 0; j < s+2; j++) sb.append(" ");
                    }
                    else {
                        sb.append(" ");
                        for (int j = 0; j < s; j++) sb.append("-");
                        sb.append(" ");
                    }
                    sb.append(" "); // 숫자 사이 공백
                }
            }

            sb.append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}

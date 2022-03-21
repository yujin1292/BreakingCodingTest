import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class week17_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String>[] list = new ArrayList[201];
        for(int i = 1; i <= 200; i++) list[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String  name = st.nextToken();
            list[age].add(name);    // 나이가 age인 회원 이름을 list[age]에 저장
        }

        StringBuilder sb = new StringBuilder();
        for (int age = 1; age <= 200; age++) {  // 회원의 나이가 증가하는 순으로 출력
            if (list[age].size() >= 1) {    // 나이가 age인 회원이 1명 이상이라면
                for (String name : list[age]) sb.append(age + " " + name).append('\n'); // 회원 정보 출력
            }
        }

        System.out.println(sb);
    }
}

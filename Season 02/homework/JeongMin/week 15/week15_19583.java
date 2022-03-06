import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class week15_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();  // 개강총회 시작 시간
        String E = st.nextToken(); // 개강총회 종료 시간
        String Q = st.nextToken();   // 개강총회 스트리밍 종료 시간

//        Map<String, String> record = new HashMap<>();
        Set<String> before_record = new HashSet<>();    // 개강총회 시작 전 채팅한 사람
        Set<String> after_record = new HashSet<>(); // 개강총회 종료 후, 스트리밍 종료 전 채팅한 사람

        String tmp;
        String time = "", nickname = "";
        while(true) {
            if ((tmp = br.readLine()) == null) break;
            st = new StringTokenizer(tmp);
            if (st.hasMoreTokens()) time = st.nextToken();
            else break;
            if (st.hasMoreTokens()) nickname = st.nextToken();
            else break;
            // 개강총회 시작 전 채팅했을 경우
            if (time.compareTo(S) <= 0 ) {
                before_record.add(nickname);
            }
            // 개강총회 종료 후, 스트리밍 종료 전 채팅했을 경우
            else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                after_record.add(nickname);
            }
        }

        // 오류 코드 - nullpointer
//        String tmp;
//        while((tmp = br.readLine()) != null) {
//            st = new StringTokenizer(tmp);
//            String time = st.nextToken();
//            String nickname = st.nextToken();
//            if (time.compareTo(S) <= 0 ) {
//                before_record.add(nickname);
//            }
//            else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
//                after_record.add(nickname);
//            }
//        }

        int count = 0;
        // before, after 기록에 닉네임이 모두 있다면 카운트
        for (String name : after_record) {
            if (before_record.contains(name)) count++;
        }

        System.out.println(count);
    }
}

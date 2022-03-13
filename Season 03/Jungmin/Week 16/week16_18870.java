import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class week16_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> originArr = new ArrayList<>();    // 원래 좌표 배열
        List<Integer> sortedArr = new ArrayList<>();    // 정렬할 좌표 배열
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            originArr.add(value);
            sortedArr.add(value);
        }

        // 오름차순 정렬
        Collections.sort(sortedArr);

        int[] result = new int[N];
        Map<Integer, Integer> points = new HashMap<>();
        result[0] = 0;
        points.put(sortedArr.get(0), result[0]);
        for (int i = 1; i < N; i++) {
            if ((sortedArr.get(i)).compareTo(sortedArr.get(i-1)) == 0) result[i] = result[i-1];
            else result[i] = result[i-1] + 1;
            points.put(sortedArr.get(i), result[i]);    // 좌표 값과 압축된 좌표 값을 매칭 -> (-10, 0), (-9, 1)
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points.get(originArr.get(i))).append(" ");    // 압축된 좌표 값이 정렬 전 원래 배열 좌표 순서대로 매칭되어서 출력
        }

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class sort_11651 {
    public static void main(String[] args) throws IOException {
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] token = (br.readLine()).split(" ");
            arr[i][0] = Integer.parseInt(token[0]);
            arr[i][1] = Integer.parseInt(token[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class sort_2751 {
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);

        for(int num : arr) sb.append(num).append('\n');

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        quickSort(arr, 0, n-1);

        for(int num : arr) sb.append(num).append('\n');

        System.out.println(sb);
    }

    public static void swap(List<Integer> list, int a, int b){
        int temp;

        temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public static void quickSort(List<Integer> list, int i, int j) {
        if (i >= j) return;

        int low = i;
        int high = j;
        int pivot = list.get((i + j) / 2);

        while (i <= j) {
            while (list.get(i) < pivot) i++;
            while (list.get(j) > pivot) j--;
            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }

        quickSort(list, low, i-1);
        quickSort(list, i, high);
    }
}

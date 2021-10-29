import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static ArrayList<Integer> tmp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        mergeSort(arr,0, arr.size()-1);

        for(int num : arr) sb.append(num).append('\n');

        System.out.println(sb);
    }

    public static void mergeSort(List<Integer> list, int low, int high) {
        if (low >= high) return;

        int pivot = (low + high) / 2;

        mergeSort(list, low, pivot);
        mergeSort(list,pivot+1, high);
        merge(list, low, high, pivot);

    }

    public static void merge(List<Integer> list, int low, int high, int pivot) {
        int i = low;
        int j = pivot+1;
        int index = low;

        while (i <= pivot && j <= high) {
            if (list.get(i) <= list.get(j)) {
                tmp.add(index++, list.get(i++));
            }
            else {
                tmp.add(index++, list.get(j++));
            }
        }

        while (i <= pivot) {
            tmp.add(index++, list.get(i++));
        }

        while (j <= high) {
            tmp.add(index++, list.get(j++));
        }

        for(int idx = 0; idx <= high; idx++) {
            list.set(idx, tmp.get(idx));
        }
    }
}

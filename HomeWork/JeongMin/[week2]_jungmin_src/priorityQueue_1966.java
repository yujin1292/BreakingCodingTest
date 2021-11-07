import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class priorityQueue_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int docNum, target, result;
        int[] priority;

        for(int i = 0; i < n; i++) {
            String[] token = (br.readLine()).split(" ");
            docNum = Integer.parseInt(token[0]);
            target = Integer.parseInt(token[1]);
            priority = new int[docNum];
            token = (br.readLine()).split(" ");
            for(int j = 0; j < docNum; j++) {
                priority[j] = Integer.parseInt(token[j]);
            }
            result = priorityQueue(docNum, target, priority);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static int priorityQueue(int docNum, int target, int[] priority) {
        if (docNum == 1) return 1;

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < docNum; i++) queue.offer(i);

        while(!queue.isEmpty()) {
            int max = 1;
            for(int i = 0; i < priority.length; i++) {
                if(max <= priority[i]) max = priority[i];
            }
            int doc = queue.poll();
            if (priority[doc] == max) {
                priority[doc] = -1;
                if (doc == target) return ++count;
                else count++;
            } else {
                queue.offer(doc);
            }
        }

        return count;
    }
}

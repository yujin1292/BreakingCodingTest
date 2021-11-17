import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryTree_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[26][2];
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 2; j++)
                graph[i][j] = -1;
        }
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = (int)st.nextToken().charAt(0) - 'A';
            String left = st.nextToken();
            String right = st.nextToken();
            if (left.charAt(0) != '.') graph[node][0] = (int)left.charAt(0) - 'A';
            else graph[node][0] = -1;
            if (right.charAt(0) != '.') graph[node][1] = (int)right.charAt(0) - 'A';
            else graph[node][1] = -1;
        }

        printPreorder(graph, 0);
        System.out.println();
        printInorder(graph, 0);
        System.out.println();
        printPostorder(graph, 0);
    }

    public static void printPreorder(int[][] graph, int v) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)('A'+v));
        System.out.print(sb);
        if(graph[v][0] != -1) printPreorder(graph, graph[v][0]);
        if(graph[v][1] != -1) printPreorder(graph, graph[v][1]);
    }

    public static void printInorder(int[][] graph, int v) {
        StringBuilder sb = new StringBuilder();
        if(graph[v][0] != -1) printInorder(graph, graph[v][0]);
        sb.append((char)('A'+v));
        System.out.print(sb);
        if(graph[v][1] != -1) printInorder(graph, graph[v][1]);
    }

    public static void printPostorder(int[][] graph, int v) {
        StringBuilder sb = new StringBuilder();
        if(graph[v][0] != -1) printPostorder(graph, graph[v][0]);
        if(graph[v][1] != -1) printPostorder(graph, graph[v][1]);
        sb.append((char)('A'+v));
        System.out.print(sb);
    }
}

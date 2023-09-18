import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int node,line,count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());   // 정점의 개수
        line = Integer.parseInt(st.nextToken());   // 간선의 개수
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        count = 0;
        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int value) {
        if(visited[value]) return;
        visited[value]=true;
        for (int i = 1; i <= node; i++) {
            if (arr[value][i] == 1) {
                dfs(i);
            }
        }

    }

}
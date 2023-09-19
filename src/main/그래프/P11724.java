import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static Boolean[] visited;
    static int node, line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        visited = new Boolean[node + 1];
        Arrays.fill(visited, false);

        // init
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        int count = 0;
        for (int i = 1; i <= node; i++) {
            if (visited[i]) continue;
            dfs(i);
            count++;
        }

        System.out.println(count);

    }

    static void dfs(int start) {

        visited[start] = true;
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}

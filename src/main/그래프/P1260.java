import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int node,line,start;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());   // 정점의 개수
        line = Integer.parseInt(st.nextToken());   // 간선의 개수
        start = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = arr[b][a] =  1;
        }

        dfs(start);
        sb.append("\n");
        visited = new boolean[node + 1];
        bfs(start);
        System.out.println(sb);

    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for (int i = 0; i <= node; i++) {
                if (arr[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
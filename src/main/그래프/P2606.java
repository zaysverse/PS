import java.io.*;
import java.util.*;

/* 바이러스
dfs() 알고리즘 사용
 */
class Main {
    static int N, result = 0;
    static int[][] arr; // 인접 행렬
    static Boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int conn = Integer.parseInt(br.readLine()); // 연결된 쌍의 수
        arr = new int[N + 1][N + 1];
        visited = new Boolean[N + 1];
        Arrays.fill(visited,false);
        for (int i = 0; i < conn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(--result);
    }

    static void dfs(int start) {
        visited[start]=true;
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
        result++;
    }
}
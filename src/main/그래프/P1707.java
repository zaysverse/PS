import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int[] color;
    static int node, line;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());
            arr = new int[node + 1][node + 1];
            color = new int[node + 1];
            result = false;

            for (int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u][v] = arr[v][u] = 1;
            }

            for (int i = 1; i <= node; i++) {
                if(color[i]==0)
                    dfs(i, 1);
            }
            if (dfs(1, 1))
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }

    static Boolean dfs(int start, int c) {
        color[start] = c;   // 값 : 1 or -1
        if(arr[start][start]==1) return false; // 루프가 있으면 이분그래프가 아니다.
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] != 1) continue;
            if (color[i]==c) return false;   // 연결되어있는 노드의 색깔이 같다면 NO
            if (color[i] == 0) {
                if (c == 1)
                    dfs(i, -1);
                else
                    dfs(i, 1);
            }
        }
        return true;
    }
}
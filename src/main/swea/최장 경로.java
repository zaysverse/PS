import java.util.*;

public class Solution {
    static int[][] arr;
    static boolean[] visited;
    static int node, line, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            node = sc.nextInt();
            line = sc.nextInt();

            arr = new int[node + 1][node +  1];
            visited = new boolean[node + 1];
            Arrays.fill(visited, false);
            max=0;

            for (int i = 0; i < line; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = arr[y][x] = 1;
            }

            for (int i = 1; i <= node; i++) {
                dfs(i, 1);
            }

            System.out.println("#" + test_case + " " + max);
        }

    }

    static void dfs(int start, int depth) {
        visited[start] = true;
        if(max < depth) max = depth;

        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[start] = false;
    }


}

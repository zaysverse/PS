import java.io.*;
import java.util.*;

/* 2468 안전영역
1. 안전영역 탐색
2. 안전 영역 탐색
dfs
n보

 */

class Main {
    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, region[i][j]);
            }
        }

        int res = 0;
        for (int height = 0; height <= max; height++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (region[i][j] > height && !visited[i][j]) {
                        cnt++;
                        dfs(i, j, height);
                    }
                }
            }
            res = Math.max(cnt, res);
        }

        System.out.println(res);


    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (region[nx][ny] <= height || visited[nx][ny]) continue;

            dfs(nx, ny, height);
        }
    }
}







import java.io.*;
import java.util.*;

/* 1012 유기농 배추
 */

class Main {

    static int[][] farm;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count, M, N, K;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            farm = new int[M][N];
            isVisited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                Arrays.fill(isVisited[i], false);
            }

            for (int i = 0; i < K; i++) {
                farm[sc.nextInt()][sc.nextInt()] = 1;
            }

            count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1 & !isVisited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX < 0 || nX >= M || nY < 0 || nY >= N) continue;
            if (farm[nX][nY] == 1 && !isVisited[nX][nY]) {
                dfs(nX, nY);
            }
        }
    }

}







import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] maze;
    static Boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new Boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        visited[0][0] = true;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';   // int형 변환
            }
        }

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int X = cur[0];
            int Y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = X + dx[i];
                int nextY = Y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                maze[nextX][nextY] = maze[X][Y] + 1;
            }
        }
    }

}
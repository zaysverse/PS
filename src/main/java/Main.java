import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
bfs()알고리즘 - 1(익은 토마토) 부터 시작
 */

class Main {
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<int[]> list = new ArrayList<>();

        // 토마토 정보 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }

        bfs();

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(map[i][j], max);
            }
        }
        System.out.println(max - 1);


    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int X = cur[0];
            int Y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = X + dx[i];
                int nextY = Y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextX][nextY] != 0) continue; // 익지 않은 토마일경우에만 로직 실행
                queue.offer(new int[]{nextX, nextY});
                map[nextX][nextY] = map[X][Y] + 1;
            }
        }
    }


}

import java.io.*;
import java.util.*;

/* 145020 연구소
0: 빈칸 , 1:벽, 2: 바이러스
dfs
 - 바이러스의 위치부터 상,하,좌,우 에 벽 세개를 세운다
bfs
 - 바이러스를 퍼트리고, 0의 숫자를 센다.
안전영역의 최댓값

 */

class Main {
    static int N, M, safe_zone;
    static int[][] map, virus_map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        safe_zone = 0;
        dfs(0);
        System.out.println(safe_zone);
    }

    static void dfs(int wall) {
        // 벽이 3개인 경우 bfs 탐색 시작
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        virus_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            virus_map[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = virus[0] + dx[i];
                int ny = virus[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (virus_map[nx][ny] == 0) {
                    virus_map[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;
        for (int[] ints : virus_map) {
            for (int i : ints) {
                if (i == 0) cnt++;
            }
        }

        safe_zone = Math.max(safe_zone, cnt);
    }

}




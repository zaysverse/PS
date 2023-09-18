import java.io.*;
import java.util.*;

/* 단지번호 붙이기
dfs() 알고리즘
 */

class Main {
    static int[][] map;
    static HashMap<Integer, Integer> result = new HashMap<>();
    static int N, number = 0;
    static Boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new Boolean[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';  //int타입 형변환
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j]==1) {
                    dfs(i, j);
                    number++;
                }
            }
        }

        System.out.println(result.size());

        // 정렬 로직
        List<Integer> list = new ArrayList<>(result.values());
        Collections.sort(list);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    static void dfs(int x, int y) {
        if (visited[x][y]) return;
        visited[x][y] = true;
        result.put(number, result.getOrDefault(number, 0) + 1);
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
            dfs(nextX, nextY);
        }
    }
}
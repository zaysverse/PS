import java.io.*;
import java.util.*;

class Main {
    static int N, K, cnt;
    static int[] dx = {-1, 1, N};
    static int[] visited = new int[100001]; // 최소시간 기록 : 이전위치에서의 시간 + 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            dx[2] = cur;
            for (int i = 0; i < 3; i++) {
                int next = cur + dx[i];
                if (next == K) {
                    System.out.println(visited[cur]);
                    return;
                }
                if (next < 0 || next > 100000 || visited[next] != 0) continue;  // 방문했을 경우 continue
                queue.offer(next);
                visited[next] = visited[cur] + 1;
            }
        }
    }
}
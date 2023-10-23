import java.io.*;
import java.util.*;

/* 1149 설탕봉지
- dp[1] != dp[2]
- dp[n] != dp[n-1]
- dp[i] != dp[i-1] != dp[i+1]

빨 파 빨 파 초 파 초 파

 */

class Main {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    static int N;
    static int[][] dp, cost;

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        System.out.print(Math.min(recur(N - 1, Red), Math.min(recur(N - 1, Green), recur(N - 1, Blue))));
    }

    static int recur(int n, int color) {
        if (dp[n][color] == 0) {    // 탐색하지 않은 배열이면
            if (color == Red) {
                dp[n][Red] = Math.min(recur(N - 1, Green), recur(N - 1, Blue)) + cost[N][Red];
            } else if (color == Green) {
                dp[N][Green] = Math.min(recur(N - 1, Red), recur(N - 1, Blue)) + cost[N][Green];
            } else {
                dp[N][Blue] = Math.min(recur(N - 1, Red), recur(N - 1, Green)) + cost[N][Blue];
            }
        }

        return dp[N][color];
    }
}







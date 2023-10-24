import java.io.*;
import java.util.*;

/* 2579 계단 오르기
  o o x
  o x o
x o o x
- dp[n] = dp[n - 1] + score[n] xxxxxxxx 마지막 계단을 밟는 경우만
        = dp[n - 2] + score[n]
        = dp[n - 3] + score[n - 1] + score[n]
 */

class Main {
    static int N;
    static Integer[] dp, score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new Integer[N+1];
        dp = new Integer[N+1];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = score[0] = 0;
        dp[1] = score[1];
        if (N >= 2)
            dp[2] = score[1] + score[2];

        System.out.println(recur(N));
    }

    static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 2), recur(n - 3) + score[n - 1]) + score[n];
        }
        return dp[n];
    }

}







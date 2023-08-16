import java.io.*;
import java.util.*;

/**
 * 10844 쉬운 계단 수
 * dp[i][j] : 길이가 i이고, j로 끝나는 수의 계단수 개수
 * <p>
 * 0 / 9 => 무조건 1 / 9이 와야한다
 * j=0 또는 j=9로 끝나는 수일때, dp[i][j]=dp[i-1][j+1]
 * j=1~8로 끝나는 수 일대, dp[i][j] = dp[i-1][j+1] + dp[i-1][j+1]
 */

public class Main {
    static int N;
    static Long[][] dp;
    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       // 길이가 N개인 계단 수를 구하라
        dp = new Long[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }

        System.out.println(result % MOD);
    }

    static long recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }

        // 해당 자리수의 val값에 대해 탐색하지 않았을 경우
        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            } else {
                dp[digit][val] = recur(digit - 1, val + 1) + recur(digit - 1, val - 1);
            }
        }
        return dp[digit][val] % MOD;
    }
}
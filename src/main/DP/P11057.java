import java.io.*;
import java.util.*;

/**
 * 11057 오르막수
 * <p>
 * dp[digit][val] : 자릿수가 digit 인 val 로 끝나는 수의 오르막수 개수
 * dp[3][5] -> xx5 = x05 + x15 + x25 + ... + x55
 * 즉, dp[digit][val] = dp[digit-1][0] + ... + dp[digit-1][val]
 * 단, val=0 이라면 dp[digit][0] = 1 이다. (무조건 0000...)
 */
public class Main {
    static Long[][] dp;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        // 마지막 자릿수인 1~9까지의 경우의 수를 모두 더한다
        Long result = 0L;
        for (int i = 0; i < 10; i++) {
            result += recur(N, i);
        }
        System.out.println(result % MOD);
    }

    static Long recur(int digit, int val) {
        if (digit == 1) {
            return dp[1][val];
        }

        // 만약 dp 안에 값이 존재하지 않다면
        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = 1L;
            } else {
                Long temp =0L;
                for (int i = 0; i <= val; i++) {
                    temp += recur(digit - 1, i);
                }
                dp[digit][val] = temp;
            }
        }
        return dp[digit][val] % MOD;
    }
}
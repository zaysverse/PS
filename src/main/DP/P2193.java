import java.io.*;
import java.util.*;


/**
 * 2193 이친수
 * - 1로만 시작함
 * - 1이 두번 연속 X. 1의 앞뒤는 무조건 0
 * <p>
 * dp[digit][val]
 * [1] = 1                           [1] - 1
 * [2] = 10                 [0] - 1
 * [3] = 100, 101           [0] - 1, [1] - 1
 * [4] = 1000, 1001, 1010   [0] - 2, [1] - 1
 * [5] = 10000, 10001, 10010, 10100, 10101       [0] - 3  [1] - 2
 * <p>
 * dp[i][0] = dp[i-1][0] + dp[i-1][1]
 * dp[i][1] = dp[i-1][0]
 */
public class Main {
    static Long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new Long[N + 1][2];
        dp[1][0] = 0L;
        dp[1][1] = 1L;

        Long result = recur(N, 0) + recur(N, 1);
        System.out.println(result);

    }

    static Long recur(int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][0] = recur(i - 1, 0) + recur(i - 1, 1);
            } else { //j==1
                dp[i][1] = recur(i - 1, 0);
            }
        }
        return dp[i][j];
    }
}
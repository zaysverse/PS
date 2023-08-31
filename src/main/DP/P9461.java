import java.util.Scanner;

/* 9461 파도반 수열
[1] 1
[2] 1
[3] 1
[4] 2 = 1 + 1 = [3] + [2]
[5] 2 = 2 = [4]
[6] 3 = 2 + 1 = [5] + [3]
[7] 4 = 3 + 1 = [6] + [1]
[8] 5 = 4 + 1 = [7] + [2]
[9] 7 = 5 + 2 = [8] + [4]
[10] 9 = 7 + 2 = [9] + [
[11] 12 = 9 + 3 = [10] + [6]
[12] 16 = 12 + 4 = [11] + [7]
[13] 21 = 16 + 5 = [12] + [8]
[14] 21 = [13]
[15] 28 = [14] + [9]
즉, 점화식은
- dp[i] = dp[i-2] + dp[i-3]
 */

public class Main {
    static Long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new Long[101];
        dp[0] = 0L;
        dp[1] = dp[2] = dp[3] = 1L;
        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            System.out.println(recur(N));
        }
    }

    static Long recur(int n) {
        if (dp[n] == null) {
            dp[n] = recur(n - 2) + recur(n - 3);
        }
        return dp[n];
    }
}
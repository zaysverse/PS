import java.util.Scanner;

/* 11055 가장 큰 증가하는 부분 수열
LIS 알고리즘
dp
 */
public class Main {
    static Integer[] seq, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        seq = new Integer[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, LIS(i));
        }
        System.out.println(result);

    }

    static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (seq[i] < seq[n])
                    dp[n] = Math.max(dp[n], LIS(i));
            }
            dp[n] += seq[n];
        }
        return dp[n];
    }
}
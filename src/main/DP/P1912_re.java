
/* 1912 연속합
input : seq[n]
연속된 몇개의 수를 선택해서 구할 수 있는 최대합
 */

import java.util.Scanner;

public class Main {
    static Integer[] seq, dp;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        seq = new Integer[N];
        dp = new Integer[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        dp[0] = seq[0];
        max = seq[0];

        recur(N - 1);
        System.out.println(max);
    }

    static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(seq[n], recur(n - 1) + seq[n]);
            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}
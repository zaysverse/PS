
/* 2579 계단 오르기
- 마지막 계단은 반드시 포함.
- 세개 연속은 불가능. 한 개는 점프 가능.

    10 20 15 25 10 20
    o  o  x             XXXXXXXXXXXXXXXXXXXXX 마지막 발판을 밟는 경우를 제한해서 메모이제이션
    o  x  o         dp[n] = dp[n-2] + seq[n]
 o  x  o  o         dp[n] = dp[n-3] + seq[n-1] + seq[n]

dp[n]: n번째 발판을 밟은, 최대점수

 */

import java.util.Scanner;

public class Main {
    static Integer[] seq, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 계단의 개수
        seq = new Integer[N + 1];
        dp = new Integer[N + 1];
        for (int i = 1; i <= N; i++) {
            seq[i] = sc.nextInt();
        }

        dp[0] = seq[0] = 0;
        dp[1] = seq[1];

        if (N >= 2) {
            dp[2] = seq[1] + seq[2];
        }

        System.out.println(recur(N));

    }

    static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 2), recur(n - 3) + seq[n - 1]) + seq[n];
        }

        return dp[n];
    }
}
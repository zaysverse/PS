
/* 11054 바이토닉 수열 : 증가 부분수열 + 감소 부분수열 로 이루어져있음
LIS 알고리즘
dp1, dp2 - 각각 증가([0]~[n-1]), 감소([n-1]~[0])하는 구간  부분수열의 길이를 구함
Math.max(dp1[i]+dp2[i+1], 현재값)
 */

import java.util.Scanner;

public class Main {
    static Integer[] seq, dpIncrease, dpDecrease;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        seq = new Integer[N];
        dpIncrease = new Integer[N];
        dpDecrease = new Integer[N];

        // input
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < N ; i++) {
            result = Math.max(result, LIS(i) + LDS(i));
        }
        System.out.println(--result);       // dp[i]부분이 중복되었으므로 -1
    }

    static int LIS(int n) {
        if (dpIncrease[n] == null) {
            dpIncrease[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (seq[i] < seq[n])
                    dpIncrease[n] = Math.max(dpIncrease[n], LIS(i) + 1);
            }
        }
        return dpIncrease[n];
    }

    static int LDS(int n) {
        if (dpDecrease[n] == null) {
            dpDecrease[n] = 1;
            for (int i = n + 1; i <= N - 1; i++) {
                if (seq[i] < seq[n])
                    dpDecrease[n] = Math.max(dpDecrease[n], LDS(i) + 1);
            }
        }
        return dpDecrease[n];
    }


}
/* 1699 제곱수의 합
input : int n
1 = 1               dp[1] = 1
2 = 1 + 1           dp[2] = dp[2-1] + 1
3 = 1 + 1 + 1       dp[3] = dp[3-1] + 1
4 = 2               dp[4] = dp[4-4] + 1  = 0 + 1
5 = 2 + 1           dp[5] = dp[5-4] + 1
*/

import java.util.*;
import java.math.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[100001];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {     // dp 2부터 채우기 시작
            dp[i] = i; //우선 자기자신으로 초기화 해둔다.
            for (int j = 1; j * j <= i; j++) { // j는 1부터 제곱 수가 i보다 작을 경우 반복한다.
                dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]); // 최소항의 개수를 찾기 위해서 저장 된 값과 점화식값을 비교하여 최솟값을 취한다.
            }
        }
        System.out.println(dp[n]);
    }
}
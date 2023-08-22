import java.util.Scanner;


/* 2156 포도주 시식
- 연속 세잔은 불가능
가장 많은 양을 마셔야함

    6 10 13 9 8 1
[2] 6 10          = [1] + wine[2] = [i-1] + wine[i]
[3] 6 _ 13       = [1] + wine[3] = [i-2] + wine[i]
[4] 6 _ 13 9     = [3] + wine[4] = [i-1] + wine[i]
[5] 6 10 _ 9 8   = [2] + wine[5] = [i-3] + wine[i-1] + wine[i]
[6] 6 10 _ 9 8 _ = [5] +   x     = [i-1] +   x
 dp[n] = Math.max(dp[n-1],
         Math.max(dp[n-2],dp[n-3]+wine[n-1]) + wine[i])
 */
public class Main {
    static Integer[] dp;
    static Integer[] wine;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        wine = new Integer[n + 1];
        dp = new Integer[n + 1];

        //input : wine[]
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        //init
        dp[0] = 0;
        dp[1] = wine[1];
        if (n > 1)
            dp[2] = wine[1] + wine[2];

        System.out.println(recur(n));
    }

    //logic
    static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(recur(n - 2), recur(n - 3) + wine[n - 1]) + wine[n], recur(n - 1));
        }
        return dp[n];
    }
}
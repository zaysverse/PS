import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[][] sticker = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            //input
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            //init
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            //logic
            for (int k = 2; k <= n; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + sticker[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + sticker[1][k];
            }

            System.out.println(Math.max(dp[0][n],dp[1][n]));

        }
    }
}
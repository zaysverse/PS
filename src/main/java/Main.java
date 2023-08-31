import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/* 11052 카드 구매하기
4 = 4 / 1,3 / 2, 2
p[1]을 i-1개 구입
p[2] i-2개 구입

dp[n] : n개의 카드를 구매하는 최대가격 값
dp[n] = Max { dp[n-i] +p[i] } // (n-i)의 카드를 구매하는 최대값 + 카드i개가 담긴 값 중 Max!
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        dp[1] = P[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = P[i];

            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
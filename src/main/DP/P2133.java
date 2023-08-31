import java.util.Scanner;

/* 2133 타일 채우기
3*n 의 벽
n이 홀수일 경우 : 0 (불가능)
n이 짝수일 경우 :
- n=2 , 3 * 2 = [2*1]*2 + [1*2]*1 / [1*2]*3

즉, 점화식은
dp[i] = dp[i-2] * 3 + (dp[i-4] +dp[i-6] +...)*2

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 2; i < N + 1; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 0; j < i - 2; j += 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}
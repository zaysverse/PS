import java.io.*;
import java.util.*;

//dp[n] = dp[n-1] + n%2
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
import java.util.Scanner;

/* 11053 가장 긴 증가하는 부분 수열
LIS 알고리즘 문제!
 */

public class Main {
    static Integer[] dp;
    static Integer[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        seq = new Integer[N];
        dp = new Integer[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        // 0 ~ N-1 까지 모든 부분수열 탐색
        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        // 최댓값 찾기
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    static int LIS(int n) {
        // 만약 탐색하지 않은 위치의 경우
        if (dp[n] == null) {
            dp[n] = 1;  // 1로 초기화

            // n 이전의 노드들을 탐색
            for (int i = n - 1; i >= 0; i--) {
                // 이전의 노드 중 seq[n]의 값보다 작은 걸 발견했을 경우
                if (seq[i] < seq[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
import java.util.*;

/* 2805. 농작물 수확하기
- 농장의 크기: 홀수 (N)
- 딱맞는 정사각형 마름모 형태 의 수익 을 구하라
n = 1, 이면 [1][1]
n = 2,

0 n-1

전체를 더한 값에서 0 을 뺌

 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();   // 농장의 크기
            int n = (N + 1) / 2;    // N = 2n + 1
            int[][] farm = new int[N][N];


            //init
            for (int i = 0; i < N; i++) {
                String[] str = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Integer.parseInt(str[j]);
                }
            }
            int sum = 0;

            //logic
            for (int i = 0; i < n; i++) {
                for (int j = n - i - 1; j < n + i; j++) {
                    sum += farm[i][j] + farm[N - i - 1][j];
                }
            }

            for (int i = 0; i < N; i++) {
                sum -= farm[n - 1][i];
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }

}

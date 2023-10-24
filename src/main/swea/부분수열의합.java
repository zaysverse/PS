import java.util.*;

/*2817

 */

public class Solution {
    static int N, K, cnt;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            recur(0, 0);
            System.out.println("#" + test_case + " "+cnt);

        }


    }

    static void recur(int idx, int sum) {
        if (sum == K) {
            cnt++;
            return;
        }

        if(sum>K || idx >= N) return;
        recur(idx + 1, sum + arr[idx]);
        recur(idx + 1, sum);
    }


}

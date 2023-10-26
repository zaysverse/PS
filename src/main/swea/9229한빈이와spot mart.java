import java.io.*;
import java.util.*;

/*
과자무게 => 두개 선택

 */

public class Solution {
    static int N, M, max;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            weight = new int[N];
            max = -1;
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }

            snack(0, 0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void snack(int idx, int sum, int cnt) {
        if (sum > M) return;
        if (cnt == 2) {
            max = Math.max(max, sum);
            return;
        }
        if (idx == N) {
            return;
        }

        snack(idx + 1, sum, cnt);   // 선택하지 않고 다음 분기로
        snack(idx + 1, sum + weight[idx], cnt + 1); // 선택
    }
}

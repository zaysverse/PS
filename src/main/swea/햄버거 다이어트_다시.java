import java.io.*;
import java.util.*;

/* 햄버거 다이어트 _ 다시
 */

public class Solution {

    static int N, limit, answer;
    static int[][] hamburgers;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();   // 재료의 개수
            limit = sc.nextInt();   // 제한 칼로리
            hamburgers = new int[N][2]; // 0: score, 1: kcal
            answer = 0;

            for (int i = 0; i < N; i++) {
                hamburgers[i][0] = sc.nextInt();
                hamburgers[i][1] = sc.nextInt();
            }

            solve(0, 0, 0);
            System.out.println("#" + test_case + " " + answer);
        }

    }

    static void solve(int idx, int score, int kcal) {
        if (kcal > limit)
            return;
        if (idx == N) {
            if (score > answer) {
                answer = score;
            }
            return;
        }

        solve(idx + 1, score + hamburgers[idx][0], kcal + hamburgers[idx][1]);
        solve(idx + 1, score, kcal);
    }

}

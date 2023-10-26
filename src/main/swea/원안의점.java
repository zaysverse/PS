import java.io.*;
import java.util.*;

/* 1차원 정원
x-d, x+d

 */

public class Solution {
    static int N, D;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i * i + j * j <= N * N) cnt++;
                }
            }

            cnt *= 4;
            cnt += 1 + N * 4;


            System.out.println("#" + test_case + " "+cnt);
        }
    }
}

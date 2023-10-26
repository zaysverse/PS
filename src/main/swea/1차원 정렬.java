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
            D = sc.nextInt();

            int water = 1 + 2 * D;
            int res = N / water;
            res = (res * water < N) ? res + 1 : res;

            System.out.println("#" + test_case + " "+res);
        }
    }
}

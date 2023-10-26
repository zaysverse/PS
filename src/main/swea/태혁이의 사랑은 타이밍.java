import java.io.*;
import java.util.*;

/* 태혁이의 사랑은 타이밍

 */

public class Solution {
    static int D, H, M;
    static int d, h, m;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            D = sc.nextInt();
            H = sc.nextInt();
            M = sc.nextInt();
            int sum = 0;

            if (D < 11 || (D == 11 && H < 11) || (D == 11 && H == 11 && M < 11)) {
                sum = -1;
            } else {
                sum += (D - 11) * 24 * 60;
                sum += (H - 11) * 60;
                sum += (M - 11);
            }


            System.out.println("#" + test_case + " "+sum);
        }
    }


}

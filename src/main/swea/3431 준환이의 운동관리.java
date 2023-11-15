import java.io.*;
import java.util.*;

/* 준환이의 운동관리

 */

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int limit = sc.nextInt();
            int up = sc.nextInt();
            int exercise = sc.nextInt();

            int result = (up < exercise) ? -1 : (limit < exercise) ? 0 : limit - exercise;

            System.out.println("#" + test_case + " " + result);

        }
    }


}

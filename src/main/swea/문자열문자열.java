import java.io.*;
import java.util.*;

/* 문자열문자열

 */

public class Solution {

    static int N, max;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            String str = sc.next();

            System.out.println("#" + test_case + " " + isPossible(str));
        }

    }

    static String isPossible(String str) {
        boolean flag = true;
        if (N % 2 != 0) return "No";
        for (int i = 0; i < N / 2; i++) {
            if (str.charAt(i) != str.charAt(i + N / 2)) {
                return "No";
            }
        }
        return "Yes";
    }


}

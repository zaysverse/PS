import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*1216 회문
arr[100][100]
 */

public class Solution {
    static int max;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = sc.nextInt();
            arr = new char[100][100];
            max = 0;

            //init
            for (int i = 0; i < 100; i++) {
                String str = sc.next();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(i);
                }
            }

            //logic

            for (int i = 100; i > 0; i--) {
                if (solve(i)) {
                    System.out.println("# " + test_case + " " + i);
                    break;
                }
            }

//            System.out.println("#" + test_case + " " + max);

        }
    }

    static boolean solve(int len) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= (100 - len); j++) {
                if (solveRow(i, j, len) || solveCol(i, j, len)) return true;
            }
        }

        return false;
    }


    static boolean solveRow(int i, int j, int len) {
        for (int k = 0; k < len / 2; k++) {
            if (arr[i][j + k] != arr[i][j + len - 1 - k]) return false;
        }
        return true;
    }

    static boolean solveCol(int i, int j, int len) {
        for (int k = 0; k < len / 2; k++) {
            if (arr[i + k][j] != arr[i + len - 1 - k][j]) return false;
        }
        return true;
    }
}

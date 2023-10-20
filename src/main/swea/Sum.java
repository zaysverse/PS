import java.util.*;

/* 1209. sum

 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;

            for (int i = 0; i < 100; i++) {
                int row = 0, col = 0;
                for (int j = 0; j < 100; j++) {
                    row += arr[i][j];
                    col += arr[j][i];
                }
                max = Math.max(max, Math.max(row, col));
            }

            int cross = 0, cross_ = 0;
            for (int i = 0; i < 100; i++) {
                cross += arr[i][i];
                cross_ += arr[i][99 - i];
            }
            max = Math.max(max, Math.max(cross,cross_));

            System.out.println("#" + test_case + " " + max);
        }
    }

}

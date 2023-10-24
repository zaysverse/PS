import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*1220
1: N극(아래로), 2:S극 (위로)

j == 1, j+
 */

public class Solution {
    static int N, cnt;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            N = sc.nextInt();
            table = new int[100][100];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    table[i][j] = sc.nextInt();
                }
            }

            for (int j = 0; j < 100; j++) {
                int flag = 0;
                for (int i = 0; i < 100; i++) {
                    if (table[i][j] == 2 && flag == 1) {
                        cnt++;
                        flag = 0;
                    } else if (table[i][j] == 1) flag = 1;

                }
            }


            System.out.println("#" + test_case + " " + cnt);

        }


    }


}

import java.io.*;
import java.util.*;

/* 6900. 주혁이의 복권 당첨

 */

public class Solution {


    static int N, M, result;
    static String[] numbers, lotto;
    static int[] money;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            result = 0;

            numbers = new String[N];
            money = new int[N];
            lotto = new String[M];

            for (int i = 0; i < N; i++) {
                numbers[i] = sc.next();
                money[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                lotto[i] = sc.next();
            }


            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    for (int k = 0; k < 8; k++) {
                        if (numbers[j].charAt(k) == '*') continue;
                        if (numbers[j].charAt(k) != lotto[i].charAt(k)) break;
                        if (k == 7) result += money[j];
                    }


                }
            }

            System.out.println("#" + test_case + " "+result);
        }
    }
}

import java.io.*;
import java.util.*;

/* 퍼펙트 셔플

 */

public class Solution {
    static int N;
    static String[] cards, shuffle;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            cards = new String[N + 1];
            shuffle = new String[N + 1];

            for (int i = 0; i < N; i++) {
                cards[i] = sc.next();
            }

            int temp = (N % 2 == 0) ? N / 2 : N / 2 + 1;
            for (int i = 0; i < N / 2; i++) {
                shuffle[2 * i] = cards[i];
                shuffle[2 * i + 1] = cards[i + temp];
            }
            if (N % 2 != 0) shuffle[N - 1] = cards[temp - 1];

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(shuffle[i] + " ");
            }
            System.out.println();
        }
    }


}

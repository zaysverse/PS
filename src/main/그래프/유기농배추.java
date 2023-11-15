import java.io.*;
import java.util.*;

/* 햄버거 다이어트 _ 다시
 */

public class Solution {

    static int count;
    static int[] K_cards, I_cards, sequence;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] cards = new boolean[19];
            K_cards = new int[9];
            I_cards = new int[9];
            sequence = new int[9];
            isSelected = new boolean[9];
            count = 0;

            for (int i = 0; i < 9; i++) {
                K_cards[i] = sc.nextInt();
                cards[K_cards[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (cards[i] != true) {
                    I_cards[idx++] = i;
                }
            }

            solve(0);

            System.out.println("#" + test_case + " " + count + " " + (362880 - count));
        }

    }


    static void solve(int depth) {
        if (depth == 9) {
            int K_score = 0, I_score = 0;
            for (int round = 0; round < 9; round++) {
                if (K_cards[round] > sequence[round]) {
                    K_score += K_cards[round] + sequence[round];
                } else if (sequence[round] > K_cards[round]) {
                    I_score += K_cards[round] + sequence[round];
                }
            }
            if (K_score > I_score) count++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;

            sequence[depth] = I_cards[i];
            isSelected[i] = true;
            solve(depth + 1);
            isSelected[i] = false;
        }
    }
}

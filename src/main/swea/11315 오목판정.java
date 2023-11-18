import java.io.*;
import java.util.*;

/* 11315. 오목 판정 D3


 */

public class Solution {

    static boolean flag;
    static int N;
    static char[][] board;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {0, 1, -1, 1};


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            board = new char[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = sc.next().toCharArray();
            }

            System.out.println("#" + test_case + " " + solution());
        }
    }

    private static String solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'o') {
                    if (solve(i, j)) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    static boolean solve(int x, int y) {
        int nx;
        int ny;

        for (int k = 0; k < 4; k++) {
            nx = x;
            ny = y;
            for (int cnt = 2; cnt <= 5; cnt++) {
                nx += dx[k];
                ny += dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if (board[nx][ny] != 'o') break;
                if (cnt == 5) return true;
            }
        }
        return false;
    }


}

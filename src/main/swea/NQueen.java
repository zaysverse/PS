import java.util.*;

/* N-Queen

 */
public class Solution {
    static int[] arr;
    static int N;   // 체스판의 크기
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            count = 0;
            arr = new int[N];

            nQueen(0);
            System.out.println("#" + test_case + " "+count);
        }
    }

    static void nQueen(int depth) {
        // 체스판을 다 채우면 카운트를 1 증가시키고 리턴
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {       // 같은 행에 존재할 경우
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                // 대각선상에 놓여있을 경우
                return false;
            }
        }
        return true;
    }

}

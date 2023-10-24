import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*1217 거듭제곱

 */

public class Solution {
    static int N, M;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            int ans = calculate(M);

            System.out.println("#" + test_case + " " + ans);

        }

    }

    static int calculate(int depth) {
        if (depth == 1) {
            return N;
        }

        return calculate(depth - 1) * N;
    }
}

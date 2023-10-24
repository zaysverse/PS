import java.io.*;
import java.util.*;

/*1234
 */

public class Solution {
    static HashSet<Integer> set;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            set = new HashSet<>();
            nums = new int[7];
            for (int i = 0; i < 7; i++) {
                nums[i] = sc.nextInt();
            }

            recur(0, 0, 0);
            List<Integer> list = new ArrayList<>(set);
            list.sort(Collections.reverseOrder());

            System.out.println("#" + test_case + " " + list.get(4));

        }
    }

    static void recur(int idx, int sum, int depth) {
        if (idx == 7) {
            if(depth ==3)
                set.add(sum);
            return;
        }

        recur(idx + 1, sum + nums[idx], depth + 1);
        recur(idx + 1, sum, depth);
    }
}

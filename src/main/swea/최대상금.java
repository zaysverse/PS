import java.util.Scanner;

/* 1244 최대상금

 */
public class Solution {
    static int max, count;
    static String[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            nums = sc.next().split("");
            count = sc.nextInt();

            max = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);


        }
    }

    public static void dfs(int start, int cnt) {
        if (cnt == count) {
            String result = "";
            for (String num : nums)
                result += num;
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //swap
                String temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                dfs(i, cnt + 1);

                //다시 swap 해서 되돌림
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}

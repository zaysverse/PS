import java.io.*;
import java.util.*;

/* 13428. 숫자 조작 D3


 */

public class Solution {
    static char[] nums;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            nums = br.readLine().toCharArray();
            
            min = max = Integer.parseInt(String.valueOf(nums));

            for (int i = 0; i < Solution.nums.length; i++) {
                for (int j = 0; j < Solution.nums.length; j++) {
                    char temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    if (nums[0] != '0' && Integer.parseInt(String.valueOf(nums)) > max) {
                        max = Integer.parseInt(String.valueOf(nums));
                    }
                    if (nums[0] != '0' && Integer.parseInt(String.valueOf(nums)) < min) {
                        min = Integer.parseInt(String.valueOf(nums));
                    }
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

            System.out.println("#" + test_case + " " + min + " " + max);
        }

    }
}

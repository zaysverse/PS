import java.io.*;
import java.util.*;

/* GNS

 */

public class Solution {
    static int N;
    static List<String> nums = Arrays.asList("ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN");
    static int[] cnts;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println(sc.next());  // #1, #2, ...
            N = sc.nextInt();       // 테스트 케이스 수
            cnts = new int[10];

            for (int i = 0; i < N; i++) {
                cnts[nums.indexOf(sc.next())]++;
            }


            for (int n = 0; n < 10; n++) {
                if (cnts[n] == 0) continue;
                for (int i = 0; i < cnts[n]; i++) {
                    System.out.print(nums.get(n)+" ");
                }
            }


//            System.out.println("#" + test_case + " ");
        }
    }


}

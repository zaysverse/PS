import java.util.*;

/*

1010
1111 1000 1011 1010


초기화값: 0000
1111

 */

public class Solution {
    static String memory;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            memory = sc.next();
            res = 0;
            char flag = '0';

            for (int i = memory.indexOf("1"); i < memory.length(); i++) {
                if (flag != memory.charAt(i)) {
                    flag = memory.charAt(i);
                    res++;
                }
            }


            System.out.println("#" + test_case + " "+res);

        }

    }


}

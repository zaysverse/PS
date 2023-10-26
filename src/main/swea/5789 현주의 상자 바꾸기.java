import java.io.*;
import java.util.*;

/* 현주의 상자 바꾸기

 */

public class Solution {
    static int N, Q;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            Q = sc.nextInt();

            int[] arr = new int[N + 1];
            Arrays.fill(arr, 0);
            
            for (int i = 1; i <= Q; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                for (int j = L; j <= R; j++) {
                    arr[j] = i;
                }   
            }


            System.out.print("#" + test_case + " ");

            for (int i = 1; i <= N; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}

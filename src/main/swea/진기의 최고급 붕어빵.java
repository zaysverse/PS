import java.util.*;

/*
(도착시간/빵만드는데 걸리는시간)*빵갯수 = 지금까지 만든 빵 개수
ㄴ (i + 1)명을 빼면 0보다 크면



 */
public class Solution {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int people = sc.nextInt();
            int time = sc.nextInt();
            int bread = sc.nextInt();
            arr = new int[people];
            boolean possible = true;

            for (int i = 0; i < people; i++) {
                arr[i] = sc.nextInt();
            }

//            2명 2초 1개
//            3 2
            Arrays.sort(arr);

            int i = 1;
            for (int arrival : arr) {
                if (arrival / time * bread <  i++) {
                    possible = false;
                    break;
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(possible ? "Possible" : "Impossible");

        }

    }

}

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 1208 Flatten
덤프 : 가장 높은 곳에 있는 상자를 가장 낮은 곳으로 옮기는 작업

 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int count = sc.nextInt();
            int[] boxes = new int[100];
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }

            for (int i = 0; i < count; i++) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }

            Arrays.sort(boxes);
            System.out.println("#" + test_case + " " + (boxes[99] - boxes[0]));
        }
    }


}

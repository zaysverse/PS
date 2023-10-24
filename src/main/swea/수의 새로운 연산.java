import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*1216 수의 새로운 연산
1,1
1,2  2,1
1,3  2,2  3,1
 */

public class Solution {
    static int p, q;
    static int px, py, qx, qy;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            p = sc.nextInt();
            q = sc.nextInt();
            int[] xyP = getMap(p);
            int[] xyQ = getMap(q);

            int ans = getValue(new int[]{xyP[0] + xyQ[0], xyP[1] + xyQ[1]});

            System.out.println("#" + test_case + " "+ans);

        }
    }

    // 좌표구하기
    static int[] getMap(int value) {
        int count = 1;
        for (int i = 1; ; i++) {
            for (int x = 1, y = i; x <= i; x++, y--) {
                if(value == count) return new int[]{x, y};
                count++;
            }
        }
    }

    // 값 가져오기
    static int getValue(int[] xy) {
        int count =1;
        for (int i = 1; ; i++) {
            for (int x = 1, y = i; x <= i; x++, y--) {
                if(x == xy[0] && y ==xy[1]) return count;
                count++;
            }
        }
    }
}

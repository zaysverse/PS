import java.io.*;
import java.util.*;

/*
i번째 건물 : i-2번째, i-1, i+1,i+2 중 가장 큰수
 */

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int answer = 0;
            int N = sc.nextInt();       // 건물의 개수
            int[] building = new int[N];

            for (int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(building[i - 1], building[i - 2]);
                int max_ = Math.max(building[i + 1], building[i + 2]);
                max = Math.max(max, max_);
                if (building[i] - max > 0)
                    answer += building[i] - max;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}




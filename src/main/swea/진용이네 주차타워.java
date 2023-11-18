import java.io.*;
import java.util.*;

/* 13428. 진용이네 주차타워
유료 주차장 : 1~n
m대의 차량들

 */

public class Solution {

    static int[] rate, weight, isParking;
    static Queue<Integer> waitCars;
    static int income;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            rate = new int[n + 1];
            weight = new int[m + 1];
            isParking = new int[n + 1];
            waitCars = new LinkedList<>();
            income = 0;

            for (int i = 1; i <= n; i++) {
                rate[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= m; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(br.readLine());

                if (car > 0) {  // 차가 주자창에 도착
                    int possible = isPossible();
                    if (possible == -1) {   // 비어있는 차가 없으면 대기
                        waitCars.offer(car);
                    } else {    // 주차
                        isParking[possible] = car;
                        income += rate[possible] * weight[car];
                    }
                } else {    // 출차
                    car *= -1; // 출차할 차의 번호. 양수로 변환.
                    int exit = exit(car);   // 출차한 차가 있던 주차장 인덱스
                    isParking[exit] = 0;
                    if (!waitCars.isEmpty()) {  // 대기하는 차가 있다면, 바로 주차
                        Integer newCar = waitCars.poll();
                        isParking[exit] = newCar;
                        income += rate[exit] * weight[newCar];
                    }
                }
            }


            System.out.println("#" + test_case + " " + income);
        }

    }

    static int isPossible() {   // 비어 있는 주차 공간의 인덱스를 반환
        for (int i = 1; i < isParking.length; i++) {
            if (isParking[i] == 0) {    // i번째 주차공간이 비어있으면
                return i;
            }
        }
        return -1;  // 꽉 차있으면 return -1
    }

    static int exit(int car) {
        for (int i = 1; i < isParking.length; i++) {
            if (isParking[i] == car) {
                return i;
            }
        }
        return 0;  // 출차할 차가 없는 경우 (무시)
    }
}

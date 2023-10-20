import java.util.*;

/* 1225. 암호 생성기
- 8개의 숫자를 입력 받는다.
- 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다.
- 다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.

 */
public class Solution {
    static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.offer(sc.nextInt());
            }

            cycle();
            queue.poll();

            System.out.print("#" + test_case);
            while (!queue.isEmpty()) {
                System.out.print(" "+queue.poll());
            }
            System.out.println(" 0");


//            System.out.println("#" + test_case + " " + sum);
        }
    }

    static void cycle() {
        while (true) {
            for (int i = 1; i <= 5; i++) {
                if(queue.peek()-i<=0) return;
                queue.offer(queue.poll() - i);
            }
        }
    }

}

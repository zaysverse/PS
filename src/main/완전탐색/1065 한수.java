import javax.swing.*;
import java.io.*;
import java.util.*;

/* 1065 한수

 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(counting(N));

    }

    static int counting(int number) {
        int cnt = 99;

        if (number < 100) {
            return number;
        } else {
            for (int i = 100; i <= number; i++) {
                int hun = i / 100; // 백의 자릿수
                int ten = (i / 10) % 10; // 십의 자릿수
                int one = i % 10;

                if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                    cnt++;
                }
            }
            return cnt;
        }

    }
}







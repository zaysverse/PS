/* 1699 제곱수의 합
input : int n
1 = 1
2 = 1 + 1
3 = 1 + 1 + 1
4 = 2
5 = 2 + 1
*/

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        recur(N);
        System.out.println(result);
    }

    static void recur(long n) {
        long sqrt = (long) Math.sqrt(n);
        result++;
        if (n - sqrt * sqrt != 0) {
            recur(n - sqrt * sqrt);
        }

    }
}
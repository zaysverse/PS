import javax.swing.*;
import java.io.*;
import java.util.*;

/* 4673 셀프 넘버

d(2) = 1 + 2 = 3
d(
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);
            if (n < 10001) {
                check[n]= true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if(!check[i]) System.out.println(i);
        }
    }

    static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }

}







import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = sc.nextInt();
        int max = min;
        for (int i = 1; i < N; i++) {
            int n=sc.nextInt();
            min=Math.min(min,n);
            max=Math.max(max,n);
        }
        System.out.println(min+" "+max);
    }
}

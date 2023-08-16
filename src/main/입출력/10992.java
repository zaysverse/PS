import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(" ".repeat(N-1));
        System.out.println("*");

        if(N==1) return;

        for(int i=2;i<N;i++){
            System.out.print(" ".repeat(N-i));
            System.out.print("*");
            System.out.print(" ".repeat(2*i-3));
            System.out.println("*");
        }

        System.out.println("*".repeat(2*N-1));
    }


}

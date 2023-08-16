import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            System.out.print(" ".repeat(i));
            System.out.println("*".repeat(2*N-2*i-1));
        }
        for(int i=2;i<=N;i++){
            System.out.print(" ".repeat(N-i));
            System.out.println("*".repeat(2*i-1));
        }
    }


}

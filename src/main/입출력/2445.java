import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(2*N-2*i));
            System.out.println("*".repeat(i));
        }
        for(int i=1;i<N;i++){
            System.out.print("*".repeat(N-i));
            System.out.print(" ".repeat(2*i));
            System.out.println("*".repeat(N-i));
        }
    }
}

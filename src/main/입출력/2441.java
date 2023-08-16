import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            System.out.print(" ".repeat(i));
            System.out.println("*".repeat(N-i));
        }
    }
}

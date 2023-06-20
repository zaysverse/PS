import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            System.out.println((sc.nextInt() + sc.nextInt()));
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;
        for (int n = 0; n < N; n++) {
            sum += numbers.charAt(n)-'0';
        }
        System.out.println(sum);
    }
}

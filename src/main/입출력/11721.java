import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int i = 0;
        while (i++ < str.length()) {
            System.out.print(str.charAt(i-1));
            if (i % 10 == 0 ) System.out.println();
        }
    }
}

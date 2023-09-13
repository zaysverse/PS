import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            String str = br.readLine();
            if(str==null) break;
            int[] cnt = new int[4];
            for (int j = 0; j < str.length(); j++) {
                char cur = str.charAt(j);
                if (cur == ' ') cnt[3]++;  //공백인지 확인
                if (Character.isUpperCase(cur)) cnt[1]++;  //대문자인지 확인
                if (Character.isLowerCase(cur)) cnt[0]++;  //소문자인지 확인
                if (Character.isDigit(cur)) cnt[2]++;  //숫자인지 확인
            }
            for (int count : cnt) {
                System.out.print(count+" ");
            }
            System.out.println();
        }

    }
}
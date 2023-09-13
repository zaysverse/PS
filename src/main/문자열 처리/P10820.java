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
                int cur = (int) str.charAt(j);
                if (cur >= 97 && cur < 123) {
                    cnt[0]++;   // 소문자 개수 + 1
                } else if (cur >= 65 && cur < 97) {
                    cnt[1]++;   // 대문자 개수 + 1
                } else if (cur >= 48 && cur <= 57) {
                    cnt[2]++;
                } else if (cur==32){
                    cnt[3]++;
                }
            }
            for (int count : cnt) {
                System.out.print(count+" ");
            }
            System.out.println();
        }

    }
}
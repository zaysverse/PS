import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 11656 접미사
문자열 S 의 접미사는 substring(i, S.length()-1)
정렬 : sort (사전순)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String[] ans = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            ans[i] = S.substring(i);
        }
        Arrays.sort(ans);
        for (String a : ans) {
            bw.write(a + "\n");
        };
        bw.flush();
        bw.close();
    }
}
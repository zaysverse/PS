import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 10808 알파벳 개수
아스키 코드 이용 => 'A' ~ 'Z' 는 65~90 , 'a' ~ 'z' 는 97~122
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);   // 단어 S의 i번째 알파벳 문자
            alphabet[(int)c - 97] ++;
        }

        for (int a : alphabet) {
            System.out.print(a+" ");
        }
    }
}
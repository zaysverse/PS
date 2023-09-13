import java.io.*;

/* 11655 ROT13
알파벳인 경우 => 변환해서 추가
다른 문자인 경우 => 그대로 추가
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cur =  S.charAt(i);
            if (Character.isUpperCase(cur)) {
                cur = (char) (cur + 13);
                if(cur>'Z') cur = (char) (cur - 26);
            }
            if (Character.isLowerCase(cur)) {
                cur = (char) (cur + 13);
                if(cur>'z') cur = (char) (cur - 26);
            }
            sb.append(cur);
        }

        System.out.println(sb);

    }
}
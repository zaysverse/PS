import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*10809 문자열 찾기
해시맵 이용 : <char, int> => 알파벳, 알파벳의 첫번째 위치
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> memory = new HashMap<>();
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);  // 문자열 S의 i번째 문자
            if(!memory.containsKey(cur)) {
                memory.put(cur, i);
            }
        }

        for (int i = 97; i < 123; i++) {
            char a = (char) i;
            if(memory.containsKey(a))
                sb.append(memory.get(a)).append(" ");
            else
                sb.append(-1).append(" ");
        }

        System.out.println(sb);

    }
}
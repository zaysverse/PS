import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 10799
레이저 () 쇠막대기  ( , )
( 를 만나면 stack.push
) 를 만나면 stack.pop
() => 레이저, result += stack.size
)) => 닫힌 문자열이므로 result += 1

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int result = 0;

        for (int i = 0; i < input.length() ; i++) {
            char cur = input.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else {
                if (input.charAt(i-1) == '(') {      // 레이저
                    result += stack.size();
                } else {            // 닫힌 막대기
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
}
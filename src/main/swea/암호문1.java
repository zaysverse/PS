import java.io.*;
import java.util.*;

/*1234
 */

public class Solution {
    static int N;
    static List<String> passwords;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(br.readLine());
            passwords = new ArrayList<>();
            String[] strings = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                passwords.add(strings[i]);
            }

            int cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cnt; i++) {
                String command = st.nextToken();    // I 입력
                insert(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(passwords.remove(0)+" ");
            }
        }

    }

    static void insert(int x, int y) {
        for (int i = 0; i < y; i++) {
            passwords.add(x + i, st.nextToken());
        }
    }

}

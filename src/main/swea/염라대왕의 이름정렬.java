import java.io.*;
import java.util.*;

/* 문자열문자열
이름의 길이가 짧을 수록 앞에
 */

public class Solution {

    static int N;
    static List<String> names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            HashSet<String> set = new HashSet<>();
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }

            names = new ArrayList<>(set);

            Collections.sort(names, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o1.length() - o2.length();
                }
            });


            System.out.println("#" + test_case);
            for (String name : names) {
                bw.write(name+"\n");
            }
            bw.flush();
        }
        bw.close();

    }


}

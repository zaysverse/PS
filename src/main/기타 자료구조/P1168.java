import java.io.*;
import java.util.*;

/*
1 2 3 4 5 6 9
0 1 2 3 4 5 6
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1; // index는 0부터 시작하므로 K에  1을 빼준다.

        List<Integer> list = new ArrayList<>();
        for (int n = 1; n <= N; n++) {
            list.add(n);
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        sb.append("<");
        for (int i = 0; i < N - 1; i++) {
            index += K;
            if (index >= list.size()) index %= list.size();
            sb.append(list.remove(index) + ", ");
        }
        sb.append(list.remove(0) + ">");
        bw.write(sb.toString()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
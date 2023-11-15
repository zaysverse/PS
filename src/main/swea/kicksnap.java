import java.io.*;
import java.util.*;

/*
 */

public class Solution {
    static int[] volume, cost;
    static int N, K, maxCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            volume = new int[N];
            cost = new int[N];
            maxCost = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                volume[i] = Integer.parseInt(st.nextToken());
                cost[i] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0, 0);

            System.out.println("#" + test_case + " " + maxCost);
        }

    }

    static void solve(int idx, int v, int c) {
        if (v > K) {
            return;
        }

        if (idx == N) {
            maxCost = Math.max(maxCost, c);
            return;
        }

        solve(idx + 1, v + volume[idx], c + cost[idx]);
        solve(idx + 1, v, c);
    }


}

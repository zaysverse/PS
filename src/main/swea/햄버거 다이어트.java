import java.util.*;

/* 5215. 햄버거 다이어트
limit 칼로리 안에서, 재료들의 점수를 더한 값이 가장 큰 값
dfs :
 */
public class Solution {
    static int[][] hamburger;       // 0.점수   1.칼로리
    static int ingredient, limit, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            ingredient = sc.nextInt();      //재료의 수
            limit = sc.nextInt();           // 제한 칼로리
            hamburger = new int[ingredient][2];

            for (int i = 0; i < ingredient; i++) {
                hamburger[i][0] = sc.nextInt();     // 점수
                hamburger[i][1] = sc.nextInt();     // 칼로리
            }

            dfs(0,0,0);
            System.out.println("#"+test_case+" "+answer);
        }
    }

    static void dfs(int start, int score ,int kcal) {
        if(kcal>limit) return;
        if (start == ingredient) {
            answer = Math.max(answer, score);
            return;
        }

        //선택한 경우 : 해당 항목의 점수, 칼로리를 더해준다. 그리고 진행.
        dfs(start + 1, score + hamburger[start][0], kcal + hamburger[start][1]);
        // 선택하지 않은 경우 : 기존의 상태에서 다음번째 항목으로 넘겨준다.
        dfs(start + 1, score, kcal);
    }
}

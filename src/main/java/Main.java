import java.io.*;
import java.util.*;

/* 1012 유기농 배추
 */

class Main {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {

        }

    }

    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int max = 0;

            int one = 1, one_score = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == one++) one_score++;
                if (one == 5) one = 1;
            }

            int two = 1, two_score = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] % 2 == 0) {
                    if (answers[i] == 2) two_score++;
                } else {
                    if (answers[i] == two) {
                        two_score++;
                        if (two == 1) two = 3;
                        if (two == 5) two = 1;
                        else two++;
                    }
                }
            }

            int three = 3, three_score=0;
            for (int i = 0; i < answers.length; i+=2) {
                if(answers[i]== three) three_score++;
                if(answers[i+1]==three) three_score++;
                if(three==5) three=3;
                else if ( three == 3) three = 1;
                else three++;
            }

            max = Math.max(one_score, Math.max(two_score, three_score));



            return answer;
        }
    }
}







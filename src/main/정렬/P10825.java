import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
1. 국어 내림차순
2. 영어 오름차순
3. 수학 내림차순
4. 이름 사전순으로 (아스키코드 이용)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Score> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.korean != o2.korean)
                return o2.korean-o1.korean;
            if(o1.english != o2.english)
                return o1.english-o2.english;
            if(o1.math != o2.math)
                return o2.math-o1.math;
            return o1.name.compareTo(o2.name);
        });

        for (Score score : list) {
            System.out.println(score.name);
        }
    }

    static class Score {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

}
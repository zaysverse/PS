import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Data> list = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(new Data(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.x == o2.x)
                    return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });

        for (Data data : list) {
            System.out.println(data.x + " " + data.y);
        }
    }

    static class Data {
        private int x;
        private int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        int max = 0;
        Long key = 0L;
        for (int i = 0; i < N; i++) {
            Long card = Long.parseLong(br.readLine());
            map.put(card, map.getOrDefault(card, 0) + 1);

            if (map.get(card) > max) {
                max = map.get(card);
                key = card;
            } else if (map.get(card) == max) {
                key = Math.min(card, key);
            }
        }

        System.out.println(key);
    }
}
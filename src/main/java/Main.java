import java.io.*;
import java.net.Inet4Address;
import java.util.*;

/*
i번째 건물 : i-2번째, i-1, i+1,i+2 중 가장 큰수
 */

class Main {
    public static void main(String[] args) throws IOException {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Arrays.stream(candies).max().stream().max().getAsInt();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}




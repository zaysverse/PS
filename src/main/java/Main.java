import java.io.*;
import java.util.*;

/*
1월1일 ~ x월y일까지의 날짜수 합
에서 7로 나눈 나머지를 이용해서 요일 구함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int sum = y - 1;
        for (int i = 1; i < x; i++) {
            switch (i) {
                case 4:
                case 6:
                case 9:
                case 11:
                    sum += 30;
                    break;
                case 2:
                    sum += 28;
                    break;
                default:
                    sum += 31;
                    break;
            }
        }
        String[] days = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        System.out.println(days[sum%7]);
    }
}

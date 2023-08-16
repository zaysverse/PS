import java.io.*;
import java.util.*;
/*
S: 1 2 3 4 5 6
B: 6 5 4 3 2 1

1 2 3
3 2 1

k=1 000
k=2, 3 001 010  /  1 2
k=  100 101 110 111 / 3  1,3  2,3  1,2,3
    1000 1001 1011 1100  ... / 4  1,4  1,2,4
 */


public class Main {
    static int N;
    static int[] B;
    static int cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            B[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        cnt = 1; // 전구 숫자가 0으로만 이루어진 경우. ex)000, 00000
        byte keyNumber = 0b1;
        for(int i=0;i<N;i++) keyNumber+=(byte)2;
        byte bulbNumber = 0b1;
        while (bulbNumber<keyNumber) {
            if (IsPossible(bulbToArray(bulbNumber)))
                cnt++;
            if(K==cnt) break;
            bulbNumber += 0b1;
        }

        if(bulbNumber>keyNumber) bulbNumber=-1;
        System.out.println(bulbNumber);

    }

    static List<Integer> bulbToArray(byte n) {
        String bulbString = String.valueOf(Integer.toBinaryString(n));
        List<Integer> result = new ArrayList<>();
        for (int i = bulbString.length() - 1; i >= 0; i--) {
            if(bulbString.charAt(i) == '1'){
                result.add(bulbString.length()-i);
            }
        }
        return result;
    }

    //앞의 전구가 연결된 스위치보다 이전의 스위치에 연결되면 불가능!
    static boolean IsPossible(List<Integer> S) {
        int cur = B[S.get(0)];
        for (int s : S) {
            if (cur < B[s]) {
                return false;
            }
            cur = B[s];
        }
        return true;
    }
}

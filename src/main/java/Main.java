import java.io.*;
import java.util.*;

/* 1065 한수

 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


    }

    class Solution {
        public boolean solution(String s) {
            if (s.length() != 4 && s.length() != 6) return false;
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)))
                    return false;
            }
            return true;
        }
    }

}







import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.pop() +"\n");
                    break;
                case "size":
                    bw.write(stack.size() +"\n");
                    break;
                case "empty":
                    bw.write(stack.empty() +"\n");
                    break;
                case "top":
                    bw.write(stack.top() +"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }


    public static class Stack {
        private int idx;
        private int[] stack;

        public Stack() {
            stack = new int[10001];
            idx = -1;
        }

        public void push(int x) {
            stack[++idx] = x;
        }

        public int pop() {
            if (idx<=-1)
                return -1;
            return stack[idx--];
        }

        public int size() {
            return idx + 1;
        }

        public int empty() {
            return (idx != -1) ? 0 : 1;
        }

        public int top() {
            if (idx == -1)
                return -1;
            return stack[idx];
        }


    }


}
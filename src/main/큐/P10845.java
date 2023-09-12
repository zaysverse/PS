import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        for (int i = 0; i < N; i++) {
            String[] com = br.readLine().split(" ");
            switch (com[0]) {
                case "push":
                    q.push(Integer.parseInt(com[1]));
                    break;
                case "pop":
                    System.out.println(q.pop());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.empty());
                    break;
                case "front":
                    System.out.println(q.front());
                    break;
                case "back":
                    System.out.println(q.back());
                    break;
            }
        }
    }

    static class Queue {
        private int[] queue;
        int front, back;

        public Queue() {
            this.queue = new int[10001];
            this.front = -1;
            this.back = -1;
        }

        void push(int x) {
            queue[++back]=x;
        }

        int pop() {
            if(front==back)
                return -1;
            return queue[++front];
        }

        int size() {
            return back-front;
        }

        int empty() {
            if (front == back)
                return 1;
            return 0;
        }

        int front() {
            if (front == back)
                return -1;
            return queue[front+1];
        }

        int back() {
            if (front == back)
                return -1;
            return queue[back];
        }
    }

}
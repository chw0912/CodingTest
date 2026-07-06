// Silver 1. 불쾌한 날

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] h, C;
    static long ans;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        h = new int[N];
        C = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        stack.push(h[0]);

        for (int i = 1; i < N; i++) {
            int data = h[i];

            while (!stack.isEmpty() && stack.peek() <= data) {
                stack.pop();
            }

            ans += stack.size();
            stack.push(data);
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


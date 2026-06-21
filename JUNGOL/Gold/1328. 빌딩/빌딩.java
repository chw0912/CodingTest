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
    static int[] H, ans;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        H = new int[N+1];
        ans = new int[N+1];
        for (int i = 1; i <= N; i++) {
            H[i] = Integer.parseInt(br.readLine().trim());
        }
    }

    static void solve() {

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && H[stack.peek()] < H[i]) {
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
    }

    static void output() throws IOException {
        for (int i = 1; i <= N; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}


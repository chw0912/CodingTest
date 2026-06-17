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
    static Stack<Tower> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < top) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(i, top));
        }
    }

    static void solve() {
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


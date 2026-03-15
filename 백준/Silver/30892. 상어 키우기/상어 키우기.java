import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static long T;
    static int[] sharks;
    static boolean[] visited;
    static long ans;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        sharks = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sharks);

    }

    static void solve() {

        int idx = 0;
        while (K-- > 0) {
            while (idx < N && sharks[idx] < T) {
                stack.push(sharks[idx]);
                idx++;
            }

            if (stack.empty()) break;

            T += stack.pop();
        }
    }

    static void output() throws IOException {
        bw.write(T + "\n");
        bw.flush();
    }
}

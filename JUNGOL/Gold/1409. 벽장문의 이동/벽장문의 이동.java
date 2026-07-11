// [Gold 5] 벽장문의 이동
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, left, right, M;
    static int ans = Integer.MAX_VALUE;
    static int[] order;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        order = new int[M];
        for (int i = 0; i < M; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }

    }

    static void solve() {
        dfs(0,left, right,0);
    }

    static void dfs(int idx, int left, int right, int move) {
        if (idx == M) {
            ans = Math.min(ans, move);
            return;
        }

        int target = order[idx];

        int l = Math.abs(target - left);
        dfs(idx + 1, target, right, move + l);

        int r = Math.abs(target - right);
        dfs(idx + 1, left, target, move + r);
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}



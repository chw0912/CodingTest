import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[] D;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = new int[N+1];
        dp = new int[N+1][M+1];

        for ( int i = 1; i <= N; i++ ) {
            D[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        for (int idx = 1; idx <= N; idx++) {
            calc(idx, D[idx]);
        }
    }

    static void output() throws IOException {
        bw.write(dp[N][0]+"\n");
        bw.flush();
    }

    static void calc(int idx, int move) {

        // 1st step
        dp[idx][0] = dp[idx-1][0];

        // 2nd step
        for (int dist = 1; dist <= M; dist++) {
            dp[idx][dist] = dp[idx-1][dist-1] + move;
        }

        // 3rd step
        for (int dist = 1; dist <= M && idx > dist; dist++) {
            dp[idx][0] = Math.max(dp[idx][0], dp[idx-dist][dist]);
        }

    }
}


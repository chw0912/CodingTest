// G2. 색상환
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int MOD = 1_000_000_003;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        dp = new int[N+1][K+1];

    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= (i+1)/2 && j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf((dp[N-3][K-1] + dp[N-1][K]) % MOD));
        bw.flush();
    }
}


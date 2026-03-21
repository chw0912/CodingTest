import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static long MOD;
    static int last;
    static long[][][] dp;
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        MOD = 1_000_000_000;
        last = 1<<10;

        dp = new long[N][10][last];

        for (int i = 1; i < 10; i++) {
            dp[0][i][1<<i] = 1;
        }
    }

    static void solve() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < last; k++) {
                    if (j == 0) {
                        dp[i][j][k|1] = (dp[i][j][k|1] + dp[i-1][j+1][k]) % MOD;
                    } else if (j == 9) {
                        dp[i][j][k|1<<9] = (dp[i][j][k|(1<<9)] + dp[i-1][j-1][k]) % MOD;
                    } else {
                        dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j+1][k]) % MOD;
                        dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j-1][k]) % MOD;
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N-1][i][last-1]) % MOD;
        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N+1];
        dp = new int[K+1];

        for ( int i = 1; i <= N; i++ ) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for ( int i = 1; i <= K; i++ ) {
            dp[i] = Integer.MAX_VALUE-1;
        }


    }

    static void solve() {
        for ( int i = 1; i <= N; i++ ) {
            int coin = coins[i];
            for ( int j = coin; j <= K; j++ ) {
                dp[j] = Math.min(dp[j], dp[j-coin] + 1);
            }
        }
    }

    static void output() throws IOException {
        if ( dp[K] == Integer.MAX_VALUE-1 ) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(dp[K]));
        }
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, W;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);

        W = Integer.parseInt(br.readLine());
        dp = new int[W+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            dp[coins[i]] = 1;

            for (int j = coins[i]+1; j <= W; j++) {
                if (dp[j-coins[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+dp[coins[i]]);
            }
        }
    }

    static void output() throws IOException {
        if (dp[W] == Integer.MAX_VALUE) bw.write("impossible\n");
        else bw.write(dp[W]+"\n");
        bw.flush();
    }
}


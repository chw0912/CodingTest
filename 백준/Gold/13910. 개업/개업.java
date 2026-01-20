import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[] wok;
    static int[] dp;
    static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wok = new int[MAX];
        dp = new int[N+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        wok[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            wok[Integer.parseInt(st.nextToken())]++;
        }

    }

    static void solve() {
        for ( int i = 1; i <= N; i++ ) {
            for (int j = 0; j <= i/2; j++ ) {
                if ( (j == i-j && wok[j] >= 2) ) {
                    dp[i] = 1;
                } else if ( j != i -j && wok[j] > 0 && wok[i-j] > 0) {
                    dp[i] = 1;
                } else if (dp[j] != MAX && dp[i-j] != MAX) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[N] >= MAX ? -1 : dp[N]));
        bw.flush();
    }
}

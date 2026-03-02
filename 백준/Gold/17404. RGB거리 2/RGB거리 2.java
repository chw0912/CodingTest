import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int INF = 1_000 * 1_000;
    static int N;
    static int[][] house;
    static int[][] dp;
    static int ans = INF;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        house = new int[N+1][3];
        dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[1][i] = house[1][i];
                else dp[1][i] = INF;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != k) ans = Math.min(ans, dp[N][i]);
            }
        }

    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }

}


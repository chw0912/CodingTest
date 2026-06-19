import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static int[] train, sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        train = new int[N+1];
        sum = new int[N+1];
        dp = new int[4][N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            train[i] = Integer.parseInt(st.nextToken());
            sum[i] = train[i] + sum[i-1];
        }
        K = Integer.parseInt(br.readLine());
    }

    static void solve() {

        for (int t = 1; t < 4; t++) {
            for (int i = K*t; i <= N-(K*(3-t)); i++) {
                int sumValue = (i-K > 0) ? sum[i] - sum[i-K] : sum[i];
                dp[t][i] = Math.max(dp[t][i-1], dp[t-1][i-K] + sumValue);
            }
        }
    }

    static void output() throws IOException {
        bw.write(dp[3][N] + "\n");
        bw.flush();
    }
}



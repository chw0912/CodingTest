import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[][] triangle;
    static int[][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i][j] , dp[i-1][j] + triangle[i][j]);
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + triangle[i][j+1]);
            }
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[N-1][i]);
        }

    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

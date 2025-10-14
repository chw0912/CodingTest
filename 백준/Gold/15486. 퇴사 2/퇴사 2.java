import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N; // 상담일수
    static int[] T; // 상담일 별 이익
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+1];

        for ( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for ( int i = 1; i <= N; i++ ) {
            int Ti = T[i] - 1;
            int Pi = P[i];

            dp[i] = Math.max(dp[i], dp[i-1]);

            if ( i + Ti <= N) {
                dp[i + Ti] = Math.max(dp[i+Ti], dp[i - 1] + Pi);
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}

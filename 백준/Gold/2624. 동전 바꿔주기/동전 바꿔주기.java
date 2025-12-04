import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int T; // 지폐의 금액
    static int K; // 동전의 가지 수
    static int[] p, n; // 동전의 금액, 동전의 개수
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        p = new int[K];
        n = new int[K];

        dp = new int[T+1];

        for (int i = 0; i < K; i++ ) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void solve() {
        dp[0] = 1;
        for ( int coin = 0; coin < K; coin++ ) {
            for ( int t = T; t >= 0; t-- ) {
                for ( int amount = 1; amount <= n[coin]; amount++ ) {
                    if ( t - (p[coin] * amount) < 0 ) break;
                    dp[t] += dp[t - (p[coin] * amount)];
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[T]));
        bw.flush();
    }
}

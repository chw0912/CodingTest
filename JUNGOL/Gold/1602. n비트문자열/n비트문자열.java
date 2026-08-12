// [Gold 5] 1602. n비트문자열

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, L;
    static long I;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        I = Long.parseLong(st.nextToken());

        dp = new long[32][32];

        for(int i = 0; i < 32; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j-1] + dp[i - 1][j];
            }
        }
    }

    static void solve() {
        for(int step  = N; step >= 1; step--) {
            int count = 0;
            for(int j = 0; j <= L; j++) {
                count += dp[step-1][j];
            }

            if(I <= count) {
                sb.append("0");
            } else {
                sb.append("1");
                I -= count;
                L--;
            }
        }

    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


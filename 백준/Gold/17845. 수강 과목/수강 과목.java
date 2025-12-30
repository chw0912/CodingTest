import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1];

        for ( int k = 0; k < K; k++ ) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for ( int j = N; j >= 0; j-- ) {
                if(j - time < 0) break;
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }

    }

//    static void solve() {
//
//    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}


// [Gold 5] 1077. 배낭채우기1

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static int[] W, V, dp;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {

            for (int j = W[i]; j <= K; j++) {
                dp[j] = Math.max(dp[j], dp[j-W[i]] + V[i]);
            }
        }
    }

    static void output() throws IOException {
        bw.write(dp[K] + "\n");
        bw.flush();
    }
}


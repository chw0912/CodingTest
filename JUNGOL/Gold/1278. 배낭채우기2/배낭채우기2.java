// [Gold 4] 1278. 배낭채우기2

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
        N =  Integer.parseInt(st.nextToken());
        K =  Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];
        dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = K; j > 0; j--) {
                if (j-W[i] >= 0) {
                    dp[j] = Math.max(dp[j], Math.max(V[i], V[i] + dp[j-W[i]]));
                } else {
                    break;
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(dp[K] + "\n");
        bw.flush();
    }
}

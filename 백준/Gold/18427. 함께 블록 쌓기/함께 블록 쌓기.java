import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, H;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> blocks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[N+1][H+1];

        for ( int i = 0; i <= N; i++ ) {
            blocks.add(new ArrayList<>());
        }

        for ( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            while ( st.hasMoreTokens() ) {
                blocks.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

    }

    static void solve() {
        for ( int i = 1; i <= N; i++ ) {
            for ( int j = 1; j <= H; j++ ) {
                for (int block :  blocks.get(i)) {
                    if ( j == block ) dp[i][j]++;
                    if ( j > block ) dp[i][j] += dp[i-1][j-block];
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[N][H]));
        bw.flush();
    }
}


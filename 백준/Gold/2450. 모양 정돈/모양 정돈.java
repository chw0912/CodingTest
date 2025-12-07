import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int  TRIANGLE = 1, SQUARE = 2, CIRCLE = 3;
    static int N;
    static int[] board;
    static int[] cnt;
    static int[][] perm = {
            {1,2,3}, {1,3,2},
            {2,1,3}, {2,3,1},
            {3,1,2}, {3,2,1}
    };

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N+1];
        cnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for ( int n = 1; n <= N; n++ ) {
            int shape = Integer.parseInt(st.nextToken());
            board[n] = shape;
            cnt[shape]++;
        }
    }

    static void solve() {
        for ( int i = 0; i<6; i++) {
            makeTmp(i);
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void makeTmp(int cur) {
        int[][] dp = new int[4][4];

        int tmpResult = 0;
        int idx = 1;

        for ( int i = 1; i <= cnt[perm[cur][0]]; i++) {
            dp[perm[cur][0]][board[idx]] += 1;
            idx++;
        }
        for ( int i = 1; i <= cnt[perm[cur][1]]; i++) {
            dp[perm[cur][1]][board[idx]] += 1;
            idx++;
        }
        for ( int i = 1; i <= cnt[perm[cur][2]]; i++) {
            dp[perm[cur][2]][board[idx]] += 1;
            idx++;
        }

        tmpResult += dp[perm[cur][0]][perm[cur][1]] + dp[perm[cur][0]][perm[cur][2]];

        tmpResult += Math.max(dp[perm[cur][1]][perm[cur][2]], dp[perm[cur][2]][perm[cur][1]]);

        ans = Math.min(ans, tmpResult);
    }

}


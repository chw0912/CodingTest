import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // 표의 크기, 구간 합의 수
    static int[][] table; // 표
    static int[][] ranges; // 구간
    static int[][] dp;
    static int[] result;
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N+1][N+1];
        ranges = new int[M+1][4];
        dp = new int[N+1][N+1];
        result = new int[M+1];

        // table
        for ( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 1; j <= N; j++ ) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ranges
        for ( int i = 1; i <= M; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0; j < 4; j++ ) {
                ranges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for ( int i = 1; i <= N; i++ ) {
            for ( int j = 1; j <= N; j++ ) {
                dp[i][j] = table[i][j]+ dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

    }

    static void solve() {

        for ( int i = 1; i <= M; i++ ) {
            x1 = ranges[i][0];
            y1 = ranges[i][1];
            x2 = ranges[i][2];
            y2 = ranges[i][3];

            result[i] = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
        }

    }

    static void output() throws IOException {
        for ( int i = 1; i <= M; i++ ) {
            bw.write(result[i]+ "\n");
        }
        bw.flush();
        bw.close();
    }
}

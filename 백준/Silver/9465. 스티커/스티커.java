import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;

    static int T; // 테스트 케이스 수
    static int N; // 스티커 개수
    static int[][] score; // 점수
    static int[] result; // 출력값
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        result = new int[T];
        for ( int t = 0; t < T; t++ ) {
            N = Integer.parseInt(br.readLine());
            score = new int[2][N];
            dp = new int[2][N];

            for ( int i = 0; i < 2; i++ ) {
                st = new StringTokenizer(br.readLine());
                for ( int j = 0; j < N; j++ ) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for ( int i = 0; i < N; i++ ) {
                if ( i == 0 ) {
                    dp[0][i] = score[0][i];
                    dp[1][i] = score[1][i];
                } else if ( i == 1 ) {
                    dp[0][i] = score[0][i] + dp[1][i-1];
                    dp[1][i] = score[1][i] + dp[0][i-1];
                } else {
                    dp[0][i] = score[0][i] + Math.max(dp[1][i-1], Math.max(dp[1][i-2], dp[0][i-2]));
                    dp[1][i] = score[1][i] + Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2]));
                }
            }

            result[t] = Math.max(dp[0][N-1], dp[1][N-1]);

        }
    }

    static void solve() {

    }

    static void output() throws IOException {
        for ( int t = 0; t < T; t++ ) {
            bw.write(result[t] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

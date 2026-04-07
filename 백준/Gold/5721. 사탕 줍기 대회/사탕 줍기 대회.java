// G4. 사탕 줍기 대회

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
//        solve();
//        output();
    }

    static void input() throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(M == 0 && N == 0) break;

            map = new int[M+1][N+1];
            dp = new int[M+1][N+1];

            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 1; n <= N; n++) {
                    map[m][n] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            output();
        }

    }

    static void solve() {

        // 가로
        // dp[i][N]에 각 행 별 최대값 저장
        for(int i = 1; i <= M; i++) {
            dp[i][1] = map[i][1];
            for(int j = 2; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i][j-2] + map[i][j]);
            }
        }

        // 세로
        // dp N열의 최대값을 저장
        for(int i = 2; i <= M; i++) {
            dp[i][N] = Math.max(dp[i-1][N], dp[i-2][N] + dp[i][N]);
        }
    }


    static void output() throws IOException {
        bw.write(dp[M][N] + "\n");
        bw.flush();
    }

}


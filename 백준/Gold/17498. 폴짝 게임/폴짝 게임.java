import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, D; // N : 행의 개수, M : 열의 개수, D :  최대 점프 거리 정수
    static int[][] board;
    static int[][] dp;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
            if (n > 0) {
                Arrays.fill(dp[n], Integer.MIN_VALUE);
            }
        }
    }

    static void solve() {
        int r = 0; // 행 인덱스
        int c = 0; // 열 인덱스
        while (r < N) {
            if(r == 0 || dp[r][c] != Integer.MIN_VALUE) {
                for (int p = r+1; p < N && (p - r) <= D; p++) {
                    int startQ = c, endQ = c;
                    int distance = D - (p-r);

                    if (startQ - distance >= 0) {
                        startQ -= distance;
                    } else {
                        startQ = 0;
                    }

                    if (endQ + distance  < M) {
                        endQ += distance;
                    } else {
                        endQ = M - 1;
                    }

                    for (int q = startQ; q <= endQ; q++) {
                        dp[p][q] = Math.max(dp[p][q], dp[r][c] + (board[r][c] * board[p][q]));

                    }
                }
            }
            c++;
            if(c == M) {
                c = 0;
                r++;
            }
        }

        for (int i = 0; i < M; i++) {
            ans = Math.max(ans, dp[N-1][i]);
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

}






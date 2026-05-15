import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int INF = 13 * 100 + 1;
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

    }

    static void solve() {
        tsp(0,1);
    }

    static int tsp(int prev, int bit) {

        // 모두 방문했을 경우
        if (bit == (1 << N) - 1) {
            if (W[prev][0] == 0) return INF;
            return W[prev][0];
        }

        // 현재 이 상태로 최적의 길이 있다면
        if (dp[prev][bit] != -1) return dp[prev][bit];

        // 최대값으로 초기화
        dp[prev][bit] = INF;

        // 방문할 도시들을 탐색
        for (int next = 0; next < N; next++) {

            // 방문할 수 있는 곳인지
            if ((bit & (1 << next)) != 0) continue;

            // 이동이 불가능한 경우
            if (W[prev][next] == 0) continue;


            dp[prev][bit] = Math.min(dp[prev][bit], tsp(next, (bit | (1 << next))) + W[prev][next]);
        }

        return dp[prev][bit];
    }
    static void output() throws IOException {
        bw.write(dp[0][1] + "\n");
        bw.flush();
    }
}
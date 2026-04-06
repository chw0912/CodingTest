import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int INF = 16 * 1_000_000 + 1;
    static int N; // 도시의 수
    static int[][] W; // W[i][j] = k
    static int[][] dp; // dp[prev][bit] = k


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
    }

    static void solve() {
        tsp(0,1);
    }

    /**
     * tsp 알고리즘
     *
     * @param prev 현재 방문한 도시
     * @param bit 현재까지 방문했던 도시
     * @return 남은 도시를 다 방문해야할 때 필요한 비용
     */
    static int tsp(int prev, int bit) {

        // 여행할 도시를 다 방문했으면
        // 출발했던 도시로 되돌아 가기
        if(bit == (1 << N) - 1) {
            if(W[prev][0] == 0) return INF;
            return W[prev][0];
        }

        // 현재 이 상태로 최적의 길이 있다면
        if(dp[prev][bit] != -1) {
            return dp[prev][bit];
        }
        
        dp[prev][bit] = INF;
        
        // 방문할 도시들을 탐색
        for(int next = 0; next < N; next++) {
            // 방문할 수 있는지 확인
            if((bit & (1 << next)) != 0) continue;

            // 길이 없는 경우
            if(W[prev][next] == 0) continue;

            // 방문 가능 하다면
            dp[prev][bit] = Math.min(dp[prev][bit], tsp(next, (bit | (1 << next))) + W[prev][next]);
        }

        return dp[prev][bit];
    }

    static void output() throws IOException {
        bw.write(dp[0][1] + "\n");
        bw.flush();
    }
}

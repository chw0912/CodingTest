import java.io.*;
import java.util.Arrays;
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
    static int ans;

    // 좌, 우, 상, 하
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

    }

    static void solve() {
        ans = dfs(0, 0);
    }

    static int dfs(int x, int y) {

        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        // 이미 최적의 경로가 있다면
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 방문 확인 위한 0 초기화
        dp[x][y] = 0;

        // 4가지 방향을 순회
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (nx < 0 || ny < 0 || nx >= M || ny >= N)  continue;
            // 현재 값보다 클 경우
            if (map[nx][ny] >= map[x][y]) continue;

            dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}



import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N; // 세로, 가로
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static final int FIRST = -1, VISITED = 0, ARRIVED = 1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map =  new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = FIRST;
            }
        }

    }

    static void solve() {
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dfs(0, 0)));
        bw.flush();
        bw.close();
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return ARRIVED;
        }
        if ( dp[x][y] != FIRST ) return dp[x][y];

        dp[x][y] = VISITED;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( nx < 0 || ny < 0 || nx >= M || ny >= N ) {
                continue;
            }
            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}

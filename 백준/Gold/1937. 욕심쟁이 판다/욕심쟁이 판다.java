import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int [N][N];
        for ( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0; j < N; j++ ) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                ans = Math.max(ans, dfs(i,j));
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int dfs(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;

        for ( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( 0 <= nx && 0 <=ny && nx < N && ny < N ) {
                if ( map[x][y] < map[nx][ny] ) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                }
            }
        }

        return dp[x][y];
    }
}


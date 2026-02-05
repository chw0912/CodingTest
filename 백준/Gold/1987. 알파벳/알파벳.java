import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C; // R: 행, C: 열
    static char[][] board;
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[26];

        for ( int i = 0; i < R; i++ ) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        dfs(0,0,0);
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

    static void dfs(int x, int y, int d) {
        int index = board[x][y] - 'A';
        if (visited[index]) {
            return;
        }

        visited[index] = true;
        ans = Math.max(ans, d + 1);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                dfs(nx, ny, d + 1);
            }
        }
        visited[index] = false;
    }
}

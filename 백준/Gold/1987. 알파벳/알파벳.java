import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C; // R: 행, C: 열
    static String[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
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
        board = new String[R][C];

        for ( int i = 0; i < R; i++ ) {
            board[i] = br.readLine().split("");
        }
    }

    static void solve() {
        dfs(0,0,0,new HashSet<>());
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

    static void dfs(int x, int y, int d, HashSet<String> set) {

        if (set.contains(board[x][y])) {
            return;
        }

        set.add(board[x][y]);

        ans = Math.max(ans, d + 1);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                dfs(nx, ny, d + 1, set);
            }
        }

        set.remove(board[x][y]);
    }
}

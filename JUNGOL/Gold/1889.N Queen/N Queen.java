import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static boolean[] visited;
    static int[] board;
    static int ans;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        visited = new boolean[N];

        Arrays.fill(board, -1);
    }

    static void solve() {
        nQueen(0);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (check(depth, i)) {
                board[depth] = i;
                visited[i] = true;
                nQueen(depth + 1);
                visited[i] = false;
                board[depth] = -1;
            }
        }

    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int k = 1;
            while (true) {
                int nx = x + dx[i] * k;
                int ny = y + dy[i] * k;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if (board[nx] == ny) return false;

                k++;
            }
        }
        return true;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


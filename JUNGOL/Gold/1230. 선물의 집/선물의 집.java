import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, ans;
    static int[][] map;
    static boolean[][] visited;
    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        visited[0][0] = true;
        int cnt = 0;
        if (map[0][0] == 2) cnt++;
        dfs(0, 0, cnt);
    }

    static void dfs(int x, int y, int cnt) {
        // 출구에 도착했을 경우
        if (x == N - 1 && y == N - 1) {
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어난 경우
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            // 벽인 경우
            if (map[nx][ny] == 1) continue;
            // 이미 방문한 경우
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            if (map[nx][ny] == 2) dfs(nx, ny, cnt + 1);
            else dfs(nx, ny, cnt);
            visited[nx][ny] = false;
        }

    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


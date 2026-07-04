import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N, ans;
    static int[][] board;
    static boolean[][][] visited;
    static Robot start, end;
    static Queue<Robot> queue = new LinkedList<>();

    // 1: 동, 2: 서, 3: 남, 4: 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] rotate = {{3, 2}, {2, 3}, {0, 1}, {1, 0} };

    public static class Robot {
        int x, y, dir, cost;

        public Robot(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M+1][N+1];
        visited = new boolean[M+1][N+1][4];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()) - 1;

        start = new Robot(x, y, dir, 0);
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken()) - 1;

        end = new Robot(x, y, dir, 0);

    }

    static void solve() {
        bfs();
    }

    static void bfs() {
        queue.offer(start);
        visited[start.x][start.y][start.dir] = true;

        while (!queue.isEmpty()) {
            Robot cur = queue.poll();

            if (cur.x == end.x && cur.y == end.y && cur.dir == end.dir) {
                ans = cur.cost;
                return;
            }
            // [명령 1] 전진 (1칸, 2칸, 3칸)
            for (int k = 1; k <= 3; k++) {
                int nx = cur.x + dx[cur.dir] * k;
                int ny = cur.y + dy[cur.dir] * k;

                if (nx < 1 || ny < 1 || nx > M || ny > N) break;
                if (board[nx][ny] == 1) break;

                if (!visited[nx][ny][cur.dir]) {
                    visited[nx][ny][cur.dir] = true;
                    queue.offer(new Robot(nx, ny, cur.dir, cur.cost + 1));
                }

            }

            // [명령 2] 회전 (좌, 우)
            for (int r = 0; r < 2; r++) {
                int nextDir = rotate[cur.dir][r];

                if (!visited[cur.x][cur.y][nextDir]) {
                    visited[cur.x][cur.y][nextDir] = true;
                    queue.offer(new Robot(cur.x, cur.y, nextDir, cur.cost + 1));
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

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
    static int R, C, ans;
    static char[][] forest;
    static Queue<Pos> queue = new LinkedList<>();

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Pos {
        int x, y, cost;

        public Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        forest = new char[R][C];

        for (int i = 0; i < R; i++) {
            forest[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (forest[i][j] == 'S') {
                    queue.offer(new Pos(i, j, 0));
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (forest[i][j] == '*') {
                    queue.offer(new Pos(i, j, 0));
                }
            }
        }

        bfs();

    }

    static void bfs() {

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int cost = cur.cost;


                // 범위 밖일 경우
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                // 바위일 경우
                if (forest[nx][ny] == 'X') continue;

                if (forest[cur.x][cur.y] == 'S' && forest[nx][ny] == 'D') {
                    ans = cost + 1;
                    return;
                }

                if (forest[cur.x][cur.y] == 'S' && forest[nx][ny] == '.') {
                    queue.offer(new Pos(nx, ny, cost + 1));
                    forest[nx][ny] = 'S';
                }

                if (forest[cur.x][cur.y] == '*' && forest[nx][ny] != '*' && forest[nx][ny] != 'D') {
                    queue.offer(new Pos(nx, ny, cost));
                    forest[nx][ny] = '*';
                }

            }
        }
    }

    static void output() throws IOException {
        if (ans == 0) {
            bw.write("impossible");
        } else {
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}



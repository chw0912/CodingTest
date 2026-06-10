import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C;
    static int ans;
    static char[][] island;
    static LinkedList<Node> queue = new LinkedList<>();

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        island = new char[R][C];

        for (int i = 0; i < R; i++) {
            island[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (island[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        queue.offer(new Node(x, y, 0));
        boolean[][] visited = new boolean[R][C];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || island[nx][ny] == 'W') {
                    ans = Math.max(ans, cur.cost);
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, cur.cost + 1));

            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


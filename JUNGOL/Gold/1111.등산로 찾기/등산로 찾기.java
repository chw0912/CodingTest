import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, ax, ay, ans = 100*100*50;
    static int[][] Mount, strength;
    static LinkedList<Node> queue  = new LinkedList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
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
        N = Integer.parseInt(br.readLine());
        Mount = new int[N+2][N+2];
        strength = new int[N+2][N+2];

        st = new StringTokenizer(br.readLine());
        ax = Integer.parseInt(st.nextToken());
        ay = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Mount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N+1; i++) {
            for (int j = 0; j <= N+1; j++) {
                strength[i][j] = 100*100*50;
            }
        }

    }

    static void solve() {
        bfs();
    }

    static void bfs() {
        queue.offer(new Node(0, 0, 0));
        strength[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N+2 || ny >= N+2) continue;

                int diff;

                if (Mount[cur.x][cur.y] >= Mount[nx][ny]) {
                    diff = Mount[cur.x][cur.y] - Mount[nx][ny];
                } else {
                    diff = (int) Math.pow(Mount[nx][ny] - Mount[cur.x][cur.y], 2);
                }

                if (strength[nx][ny] <= cur.cost + diff) continue;

                strength[nx][ny] = cur.cost + diff;
                queue.offer(new Node(nx, ny, cur.cost + diff));
            }
        }

    }

    static void output() throws IOException {
        bw.write(strength[ax][ay] + "\n");
        bw.flush();
    }
}


// [Gold 1] 1008. 경로찾기(find route)

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int MAX_SIZE = (100 * 100 * 10_000) + 1;
    static final int MAX_TIME = 5_001;
    static int N, T;
    static Node start;
    static int ans = MAX_SIZE;

    static int[][] map, time;

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Node implements Comparable<Node> {
        int x, y, cost, time;

        public Node(int x, int y, int cost, int time) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.time = time;
        }
        @Override
        public int compareTo(Node o) {
            if (this.cost == o.cost) {
                return this.time - o.time;
            }

            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        time = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                map[i][j] = cost;

                time[i][j] = MAX_TIME;

                if (cost == -1) {
                    start = new Node(i, j,0,0);
                }
            }
        }
    }

    static void solve() {
        ans = bfs();
    }

    static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (map[cur.x][cur.y] == -2) {
                return cur.cost;
            }

            if (time[cur.x][cur.y] <= cur.time) continue;
            time[cur.x][cur.y] = cur.time;

            if (cur.time > T) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 0) continue;

                int nextCost = cur.cost;

                if (map[nx][ny] > 0) {
                    nextCost += map[nx][ny];
                }

                pq.offer(new Node(nx, ny, nextCost, cur.time + 1));
            }
        }
        return -1;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


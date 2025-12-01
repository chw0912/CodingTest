import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K; // 시험관 크기, 바이러스 개수
    static int[][] map;
    static boolean[][] visited;
    static int S, X, Y;
    // 동, 서, 남, 북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new ArrayDeque<>();
    static List<List<Node>> virusDir = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i <= K; i++) {
            virusDir.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                virusDir.get(v).add(new Node(i, j));
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        
        bfs();
    }

    static void output() throws IOException {
        bw.write(String.valueOf(map[X-1][Y-1]));
        bw.flush();
        bw.close();
    }

    static void bfs() {
        for (int k = 1; k <= K; k++) {
            for (Node node : virusDir.get(k) ) {
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int x = curNode.x;
            int y = curNode.y;
            int second = curNode.second;

            if (second >= S) return;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y];
                    queue.offer(new Node(nx, ny, second+1));
                }
            }
        }
    }

    static class Node {
        int x, y;
        int second;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int second) {
            this.x = x;
            this.y = y;
            this.second = second;
        }
    }
}

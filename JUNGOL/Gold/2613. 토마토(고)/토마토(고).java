import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N, ans; // M : 열, N : 행, ans : 정답(최소 일수)
    static int[][] basket; // 토마토의 정보를 담는 배열 -> 1: 익은 토마토, 0 : 익지않은 토마토, -1 : 토마토가 들어있지 않은 칸
    static Queue<Node> queue = new LinkedList<>();
    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static class Node {

        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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

        basket = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                basket[i][j] = Integer.parseInt(st.nextToken());
                if (basket[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }
    }

    static void solve() {

        while (!queue.isEmpty()) {
            bfs();
        }
        if (!check()) ans = -1;
    }


    static void bfs() {
        ArrayList<Node> dirs = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위를 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 이미 익은 토마토 또는 토마토가 들어있지 않은 칸인 경우
                if (basket[nx][ny] == 1 || basket[nx][ny] == -1) continue;

                // 토마토 익히기
                basket[nx][ny] = 1;
                dirs.add(new Node(nx, ny));
            }
        }
        if (dirs.isEmpty()) return;
        // 최소 일수를 구하기 위해 한번에 큐로 옮기기
        for (Node node : dirs) {
            queue.offer(node);
        }
        ans++;
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (basket[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}
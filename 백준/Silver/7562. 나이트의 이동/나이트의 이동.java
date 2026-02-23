import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int T, I;
    static int startX, startY;
    static int endX, endY;
    static boolean[][] visited;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            dq.clear();

            solve();

        }
    }

    static void solve() {
        dq.offer(new int[] {startX, startY, 0});

        // 방문 처리
        visited[startX][startY] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            if (x == endX && y == endY) {
                sb.append(d).append("\n");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]) {
                    dq.offer(new int[] {nx, ny, d+1});
                    visited[nx][ny] = true;
                }
            }

        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


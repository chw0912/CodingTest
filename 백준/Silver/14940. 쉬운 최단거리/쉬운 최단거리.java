import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int startX, startY;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int land = Integer.parseInt(st.nextToken());
                arr[i][j] = land;
                if (land == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
    }

    static void solve() {
        bfs();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    static void output() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void bfs() {
        dq.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        arr[startX][startY] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] + 1;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

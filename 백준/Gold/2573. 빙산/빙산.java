import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[][] icebergZone;
    static boolean[][] visited;
    static int[] dx = { 1 , -1, 0, 0 }; // 동 서 남 북
    static int[] dy = { 0 , 0, 1, -1 }; // 동 서 남 북
    static Deque<int[]> dq = new ArrayDeque<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        icebergZone = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if ( map[i][j] != 0 ) {
                    icebergZone[i][j] = true;
                } else {
                    icebergZone[i][j] = false;
                }
                visited[i][j] = false;
            }
        }
    }

    static void solve() {

        while ( icebergArea() < 2 ) {
            if ( icebergArea() == 0 ) {
                answer = 0;
                break;
            }
            warming();
            answer++;
        }
    }

    static void output() throws IOException {
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 지구 온난화
    static void warming() {

        for ( int x = 0; x < N; x++) {
            for ( int y = 0; y < M; y++) {
                for ( int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if ( nx >= 0 && ny >= 0 && nx < N && ny < M)  {
                        if ( !icebergZone[x][y] && icebergZone[nx][ny] && map[x][y] == 0 && map[nx][ny] != 0 ) {
                            map[nx][ny] -= 1;
                            if (map[nx][ny] <= 0) {
                                map[nx][ny] = 0;
                                dq.offer(new int[] { nx, ny });
                            }
                        }

                    }
                }

            }
        }

        // 다 돌고 방문 처리
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            icebergZone[cur[0]][cur[1]] = false;
        }
    }
    static int icebergArea() {
        visited = new boolean[N][M];
        int area = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ( map[i][j] != 0 &&  !visited[i][j] ) {
                    dfs(i, j);
                    area++;
                }
            }
        }

        return area;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for ( int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( nx >= 0 && ny >= 0 && nx < N && ny < M ) {
                if ( map[nx][ny] != 0 && !visited[nx][ny] ) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

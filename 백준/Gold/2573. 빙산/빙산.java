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
    static int[][] map; // 입력 데이터
    static boolean[][] icebergZone; // 빙산인지 확인하기 위한 배열
    static boolean[][] visited; // 방문 처리하기 위한 배열
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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 현재 위치가 빙산이면 true, 아니면 false
                icebergZone[i][j] = map[i][j] != 0;
            }
        }
    }

    static void solve() {

        int area;
        // 빙산 구역이 2개 이상이면 탈출
        // 또는 분리된 빙산 구역이 없다면 탈출
        while ( (area = icebergArea()) < 2 ) {
            if ( area == 0 ) {
                answer = 0;
                break;
            }
            // 지구 온난화
            warming();
            answer++;
        }
    }

    static void output() throws IOException {
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 지구 온난화 로직
    static void warming() {

        for ( int x = 0; x < N; x++) {
            for ( int y = 0; y < M; y++) {
                // 동, 서, 남, 북을 돌면서
                // 방문 가능한 범위에서 빙산 녹이기
                for ( int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    // 가능한 범위
                    if ( nx >= 0 && ny >= 0 && nx < N && ny < M)  {
                        // 현재 빙산(x, y)이 아니고
                        // 현재 좌표(x, y)가 0이고
                        // 다음 좌표(nx, ny)가 빙산이고
                        // 다음 좌표(nx, ny)가 0이 아니면
                        if ( !icebergZone[x][y] && map[x][y] == 0 && icebergZone[nx][ny]  && map[nx][ny] != 0 ) {
                            // 다음 좌표(nx, ny)의 빙산을 녹인다
                            map[nx][ny]--;
                            // 녹인 빙산이 음수가 될 수 없으므로 0
                            if (map[nx][ny] <= 0) {
                                map[nx][ny] = 0;
                                // 다음 해에는 빙산이 아니기 때문에
                                // dq에 다음 좌표(nx, ny)를 추가
                                dq.offer(new int[] { nx, ny });
                            }
                        }
                    }
                }

            }
        }

        // 빙산을 녹인 후
        // 다음 해에 빙산이 아닌 좌표는 false
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            icebergZone[cur[0]][cur[1]] = false;
        }
    }

    // 빙산 구역 구하기
    static int icebergArea() {
        visited = new boolean[N][M];
        // 빙산 구역의 개수
        int area = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 현재 좌표가 0이 아니고 방문한적 없으면
                // 빙산이기때문에 빙산 구역을 구한다
                if ( map[i][j] != 0 &&  !visited[i][j] ) {
                    dfs(i, j);
                    area++;
                }
            }
        }

        return area;
    }

    // 이어져 있는 빙산 방문처리 로직
    static void dfs(int x, int y) {
        visited[x][y] = true;

        // 다음 좌표에 빙산이 존재하면
        // 재귀하며 방문 처리 하기
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

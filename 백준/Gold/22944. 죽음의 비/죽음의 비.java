import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, H, D; // 한변의 길이, 현재 체력, 우산의 내구도
    static char[][] map;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int[][] visited;
    static int[] start, end;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 현재 위치, 안전 지대 좌표 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                }
            }
        }
    }

    static void solve() {
        bfs();
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

    static void bfs() {
        // 출발 x 좌표, 출발 y 좌표, 현재 채력, 이동 횟수, 우산 내구도
        int[] player = new int[]{start[0], start[1], H, 0, 0};
        dq.offer(player);
        visited[start[0]][start[1]] = H;

        map[start[0]][start[1]] = '.';

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int hp = cur[2];
            int move = cur[3];
            int umbrella = cur[4];

            if (hp <= 0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖일 때,
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (map[nx][ny] == '.') {
                    // 이미 좋은 컨디션으로 확인을 한 경우,
                    if (hp + umbrella - 1 <= visited[nx][ny]) continue;
                    if (umbrella > 0) {
                        dq.offer(new int[]{nx, ny, hp, move + 1, umbrella - 1});
                    } else {
                        dq.offer(new int[]{nx, ny, hp - 1, move + 1, 0});
                    }
                    visited[nx][ny] = hp + umbrella - 1;
                } else if (map[nx][ny] == 'U') {
                    // 이미 좋은 컨디션으로 확인을 한 경우,
                    if (hp + D - 1 <= visited[nx][ny]) continue;
                    dq.offer(new int[]{nx, ny, hp, move + 1, D - 1});
                    visited[nx][ny] = hp + D - 1 ;
                } else if (map[nx][ny] == 'E') {
                    ans = move + 1;
                    return;
                }

            }

        }
    }
}

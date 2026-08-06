// [Gold 5] 1049. 가까운 숫자

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[][] map, ans, dist;
    static int[][] origin; // ★ 출발지를 추적할 배열 추가

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = new int[N][N];
        dist = new int[N][N];
        origin = new int[N][N]; // 초기화

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }
    }

    static void solve() {
        Queue<int[]> queue = new LinkedList<>();

        // 1. 초기 세팅
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                    ans[i][j] = map[i][j];
                    origin[i][j] = i * N + j; // ★ 각 원소마다 고유 ID(좌표 번호) 부여
                } else {
                    origin[i][j] = -1; // 빈 칸은 -1로 초기화
                }
            }
        }

        // 2. BFS 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 큐에서 꺼낼 때의 최종 확정된 출처(origin)와 값을 가져옵니다.
            int curOrigin = origin[x][y];
            int curAns = ans[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // [케이스 1] 처음 방문하는 경우
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    origin[nx][ny] = curOrigin; // 출처 기록
                    ans[nx][ny] = curAns;       // 값 기록
                    queue.offer(new int[]{nx, ny});
                }
                // [케이스 2] 이미 방문했지만 최단 거리가 같은 경우 (동시 도달)
                else if (dist[nx][ny] == dist[x][y] + 1) {
                    // ★ 값이 아니라 "출발한 고유 위치(origin)"가 다른지 확인!
                    if (origin[nx][ny] != curOrigin) {
                        origin[nx][ny] = -2; // -2를 '무승부(여러 원소가 섞임)' 상태로 정의
                        ans[nx][ny] = 0;     // 값을 0으로 변경
                    }
                }
            }
        }
    }

    static void output() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

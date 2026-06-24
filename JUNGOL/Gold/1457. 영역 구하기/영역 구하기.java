import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N, K, cnt, ans; // M: 행, N : 열, K : 도형의 개수, cnt : 도형의 크기, ans : 영역의 개수
    static int x1, y1, x2, y2;
    static int[][] map;
    static ArrayList<Integer> area = new ArrayList<>();
    static int[] temp;

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            // x : 행, y : 열
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            for (int x = x1+1; x <= x2; x++) {
                for (int y = y1+1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
    }

    static void solve() {
        for (int m = 1; m <= M; m++) {
            for (int n = 1; n <= N; n++) {
                if (map[m][n] == 0) {
                    cnt = 1;
                    dfs(m, n);
                    ans++;
                    area.add(cnt);
                }
            }
        }
        Collections.sort(area);
    }

    static void dfs(int x, int y) {
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어난 경우
            if (nx <= 0 || ny <= 0 || nx > M || ny > N) continue;
            // 이미 채워진 공간이면 -> 1 : 도형으로 채워진 구역, 2 : 지나온 구역
            if (map[nx][ny] > 0) continue;

            map[nx][ny] = 2;
            cnt++;
            dfs(nx, ny);
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        for (int a : area) {
            bw.write(a + " ");
        }
        bw.newLine();
        bw.flush();
    }
}


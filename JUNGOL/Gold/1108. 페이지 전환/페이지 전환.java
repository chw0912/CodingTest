// [Gold 4] 1108. 페이지 전환

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int INF = 999_999;

    static int E, maxNode, total; // E: 페이지 이동 개수, maxNode: 가장 큰 페이지 번호, total: 페이지 총 개수
    static int[][] dist;
    static double answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        E = Integer.parseInt(br.readLine());

        dist = new int[501][501];

        // 인접 행렬 초기화
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dist[x][y] = 1;

            maxNode = Math.max(maxNode, x);
        }

    }

    static void solve() {

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= maxNode; k++) {
            for (int i = 1; i <= maxNode; i++) {
                for (int j = 1; j <= maxNode; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= maxNode; i++) {
            for (int j = 1; j <= maxNode; j++) {
                if (i != j && dist[i][j] != INF) {
                    answer += dist[i][j];
                    total++;
                }
            }
        }

    }

    static void output() throws IOException {
        if (total == 0) {
            bw.write("0.0\n");
        } else {
            bw.write(String.format("%.3f\n", answer/total));
        }
        bw.flush();
    }
}


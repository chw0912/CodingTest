// G4. 최소비용신장트리

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[][] costs;
    static boolean[] visited;
    static int[] minEdges;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        visited = new boolean[N];

        // 다른 정점에서 자신으로 향하는 최소 간선 비용
        minEdges = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            minEdges[i] = Integer.MAX_VALUE;
        }

    }

    static void solve() {
        // 0번 정점을 시작점으로 설정
        minEdges[0] = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minEdge = -1;

            // 방문하지 않은 정점 중 최소 간선 비용을 가지는 정점 찾기
            for (int j = 0; j < N; j++) {
                if (!visited[j] && minEdges[j] < min) {
                    min = minEdges[j];
                    minEdge = j;
                }
            }

            // 정점 방문 처리
            visited[minEdge] = true;
            // 비용 처리
            ans += min;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && costs[minEdge][j] < minEdges[j]) {
                    minEdges[j] = costs[minEdge][j];
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

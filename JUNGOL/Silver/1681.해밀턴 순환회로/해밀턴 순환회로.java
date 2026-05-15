import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int ans = 13 * 100 + 1;
    static int[][] W;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        dfs(1,1,0);
    }

    static void dfs(int cur, int depth, int cost) {
        if (cost >= ans) return;

        if (depth == N) {
            if (W[cur][1] == 0) return;
            ans = Math.min(ans, cost+W[cur][1]);
            return;
        }

        for (int next = 2; next <= N; next++) {
            if (visited[next]) continue;
            if (W[cur][next] == 0) continue;

            visited[next] = true;
            dfs(next, depth + 1, cost + W[cur][next]);
            visited[next] = false;
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}
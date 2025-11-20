import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N; // 정점의 개수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        visited = new boolean[N+1];

        for ( int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    static void solve() {
        dfs(1);
    }

    static void output() throws IOException {
        bw.write(Math.min(dp[1][0], dp[1][1])+"\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int parent) {
        visited[parent] = true;
        dp[parent][0] = 0;
        dp[parent][1] = 1;

        for ( int child : graph.get(parent)) {
            if (!visited[child]) {
                dfs(child);
                dp[parent][0] += dp[child][1];
                dp[parent][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}

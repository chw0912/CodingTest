// Gold 3. 양팔저울

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, max_size; // N : 추의 개수, M : 구슬의 개수
    static int[] W, G; // W : 추들의 무게, G : 구슬의 무게
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    // 추의 개수는 30 이하, 추의 무게는 500 이하
    // 구슬의 개수는 7 이하, 구슬의 무게는 0 이상 40,000 이하


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }


        dp = new boolean[31][15_001];
        M = Integer.parseInt(br.readLine());
        G = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            G[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {

        dfs(0, 0);

        for (int i = 0; i < M; i++) {
            if (G[i] > 15_000) sb.append("N").append(" ");
            else sb.append((dp[N][G[i]]) ? "Y" : "N").append(" ");
        }


    }

    public static void dfs(int idx, int weight) {
        if (dp[idx][weight]) return;

        dp[idx][weight] = true;
        if (idx == N) return;

        dfs(idx + 1, weight);
        dfs(idx + 1, weight + W[idx+1]);
        dfs(idx+1, Math.abs(weight - W[idx+1]));
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] costs, parents;
    static int ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        costs = new int[N+1];
        parents = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v =  Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w);
        }

    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            if (parents[i] == i) {
                ans += costs[i];
            }
        }
        sb.append(ans <= K ? ans: "Oh no");
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (costs[a] < costs[b]) {
                parents[b] = a;
            } else {
                parents[a] = b;
            }
        }
    }

    static int find(int n) {
        if (n == parents[n]) {
            return n;
        } else {
            return parents[n] = find(parents[n]);
        }
    }
}

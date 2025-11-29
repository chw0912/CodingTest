import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<ArrayList<Integer>> small = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> big = new ArrayList<>();
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            big.add(new ArrayList<>());
            small.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            big.get(s).add(b);
            small.get(b).add(s);
        }
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            int bigger = dfs(big, i, 0);

            visited = new boolean[N+1];
            int smaller = dfs(small, i, 0);

            if ( bigger + smaller == N - 1 ) {
                ans++;
            }

        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static int dfs(ArrayList<ArrayList<Integer>> graph, int node, int cnt) {

        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                cnt += dfs(graph, next, 1);
            }
        }

        return cnt;
    }
}

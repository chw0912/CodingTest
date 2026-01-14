import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int edge;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for ( int n = 0; n <= N; n++ ) {
            adj.add(new ArrayList<>());
        }

        for ( int e = 0; e < edge; e++ ) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(p).add(c);
            adj.get(c).add(p);
        }
    }

    static void solve() {
        dfs(1);
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void dfs(int n) {
        visited[n] = true;
        for (int x : adj.get(n)) {
            if (!visited[x]) {
                dfs(x);
                ans++;
            }
        }
    }
}


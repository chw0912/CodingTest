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
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] pTree;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        pTree = new int[N+1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.get(x).add(y);
            tree.get(y).add(x);
        }

    }

    static void solve() {
        dfs(1);
    }

    static void output() throws IOException {
        for (int i = 2; i <= N; i++) {
            bw.write(pTree[i] + "\n");
        }
        bw.flush();
    }

    static void dfs(int x) {
        if (visited[x]) {
            return;
        }

        visited[x] = true;

        for (int next : tree.get(x)) {
            dfs(next);
            pTree[next] = x;
        }
    }
}

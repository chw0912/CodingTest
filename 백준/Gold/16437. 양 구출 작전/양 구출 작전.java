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
    static char type;
    static int a, p;
    static int[] amount;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static long ans;

    static class Node {
        int amount;
        ArrayList<Integer> next = new ArrayList<>();

        Node(int amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        amount = new int[N+1];

        for ( int n = 0; n <= N; n++ ) {
            graph.add(new ArrayList<>());
        }
        for ( int n = 2; n <= N; n++ ) {
            st = new StringTokenizer(br.readLine());
            type = st.nextToken().charAt(0);
            a = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            if ( type == 'S' ) {
                amount[n] = a;
                graph.get(p).add(n);
            } else {
                amount[n] = (-1) * a;
                graph.get(p).add(n);
            }

        }
    }

    static void solve() {
        ans = dfs(1);
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static long dfs(int cur) {
        long result = amount[cur];

        for ( int next : graph.get(cur) ) {
            result += dfs(next);
        }

        return Math.max(result, 0);
    }
}


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
    static boolean[] visited;
    static ArrayList<Node> graph = new ArrayList<>();
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
        visited = new boolean[N+1];

        for ( int n = 0; n <= N; n++ ) {
            graph.add(new Node(0));
        }
        for ( int n = 2; n <= N; n++ ) {
            st = new StringTokenizer(br.readLine());
            type = st.nextToken().charAt(0);
            a = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            Node cur = graph.get(n);
            if ( type == 'S' ) {
                cur.amount = a;
                graph.get(p).next.add(n);
            } else {
                cur.amount = (-1)*a;
                graph.get(p).next.add(n);
            }

        }
    }

    static void solve() {

        ans = dfs(graph.get(1));

    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static long dfs(Node cur) {
        if ( cur.next.isEmpty() ) {
            // 음수이면 0을 리턴
            return Math.max(cur.amount, 0);
        }
        long result = cur.amount;

        for ( int next : cur.next ) {
            Node nextNode = graph.get(next);
            result += dfs(nextNode);
        }

        return Math.max(result, 0);
    }
}


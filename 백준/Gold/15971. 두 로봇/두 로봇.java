import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, S, E;
    static ArrayList<ArrayList<Node>> cave = new ArrayList<>();
    static boolean[] visited;
    static int ans;

    public static class Node {
        int next, cost;

        public Node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }

    public static class path implements Comparable<path> {
        int idx, cost, max;
        public path(int idx, int cost, int max) {
            this.idx = idx;
            this.cost = cost;
            this.max = max;
        }

        @Override
        public int compareTo(path o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++){
            cave.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향
            cave.get(from).add(new Node(to, cost));
            cave.get(to).add(new Node(from, cost));
        }

    }

    static void solve() {
        dijkstra();
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

    static void dijkstra() {
        PriorityQueue<path> pq = new PriorityQueue<>();
        pq.offer(new path(S, 0, 0));
        visited[S] = true;

        while (!pq.isEmpty()){
            path cur = pq.poll();

            if (cur.idx == E) {
                ans = cur.cost - cur.max;
                return;
            }

            for (Node node : cave.get(cur.idx)) {
                if (!visited[node.next]) {
                    visited[node.next] = true;
                    pq.offer(new path(node.next, cur.cost + node.cost, Math.max(cur.max, node.cost)));
                }
            }
        }


    }
}

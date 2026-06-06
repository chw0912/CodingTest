import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int INF = 101;
    static int N, M; // N: 지하철역의 수, M: 목적지 역 번호
    static int[][] S; // i에서 j까지 가는데 걸리는 시간을 저장한 배열
    static boolean[] visited;
    static int[] dist, prev;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
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
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];
        prev = new int[N+1];

        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost == 0) continue;
                adj.get(i).add(new Node(j, cost));
            }
        }

        Arrays.fill(dist, INF);
        dist[1] = 0;
    }

    static void solve() {
        dijkstra(1);
    }

    static void dijkstra(int start) {
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.index]) continue;
            visited[curr.index] = true;

            for (Node next : adj.get(curr.index)) {
                if (dist[next.index] > dist[curr.index] + next.cost) {
                    dist[next.index] = dist[curr.index] + next.cost;
                    prev[next.index] = curr.index;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(dist[M] + "\n");

        ArrayList<Integer> route = new ArrayList<>();
        int current = M;

        while (current != 0) {
            route.add(current);
            current = prev[current];
        }

        for (int i = route.size() - 1; i >= 0; i--) {
            bw.write(route.get(i) + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}

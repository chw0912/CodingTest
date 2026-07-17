// [Gold 2] 1208. 귀가

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
    static final int MAX_SIZE = 52, UPPER = 97, LOWER = 65, MID = 26;
    static int P; // 길의 개수
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Node>> pasture = new ArrayList<>(); // a ~ z : 0 ~ 25, A ~ z : 26 ~ 51;
    static StringBuilder sb = new StringBuilder();
    public static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        P = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < MAX_SIZE; i++) {
            pasture.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            char s =  st.nextToken().charAt(0);
            char e = st.nextToken().charAt(0);

            int start = s >= 'a' ? s - 'a' : s - 'A' + MID;
            int end = e >= 'a' ? e - 'a' : e - 'A' + MID;

            int cost = Integer.parseInt(st.nextToken());

            pasture.get(end).add(new Node(start, cost));
            pasture.get(start).add(new Node(end, cost));

        }
    }

    static void solve() {
        dijkstra(MAX_SIZE-1);

        int minCost = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 26; i < 51; i++) {
            if (dist[i] < minCost) {
                minCost = dist[i];
                index = i;
            }
        }

        sb.append((char) (index - 26 + 'A')).append(" ").append(minCost);
    }

    // Z 부터 시작해서 연결되어 있는 노드가 없을때까지 탐색
    // 연결이 끊기면 해당 노드까지의 거리와 노트 번호를 출력
    // cur : Z와 연결된 노드
    static void dijkstra(int start) {
        dist = new int[MAX_SIZE];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 짧은 경로가 존재하는 경우
            if (dist[cur.idx] < cur.cost) continue;


            for (Node next : pasture.get(cur.idx)) {
                int nextDist = cur.cost + next.cost;

                if (dist[next.idx] > nextDist) {
                    dist[next.idx] = nextDist;
                    pq.offer(new Node(next.idx, nextDist));
                }

            }

        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}





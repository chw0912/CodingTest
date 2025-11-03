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
    static int V, E; // 정점의 개수, 간선의 개수
    static int K; // 시작 정점의 번호
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited; // 방문기록 1-based
    static int[] distance; // 거리 1-based
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

    static class Node {
        int index; //
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for ( int i = 0; i <= V; i++ ) {
            graph.add(new ArrayList<>());
        }

        for ( int i = 0; i < E; i++ ) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        distance = new int[V+1];

        for ( int i = 1; i <= V; i++ ) {
            distance[i] = Integer.MAX_VALUE;
        }

    }

    static void solve() {
        pq.offer(new Node(K, 0));
        distance[K] = 0;

        while ( !pq.isEmpty() ) {
            Node curNode = pq.poll();

            if ( distance[curNode.index] < curNode.weight ) {
                continue;
            }

            for ( int i = 0; i < graph.get(curNode.index).size(); i++ ) {
                Node adjNode = graph.get(curNode.index).get(i);

                if ( distance[adjNode.index] > curNode.weight + adjNode.weight ) {
                    distance[adjNode.index] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.index, distance[adjNode.index]));
                }
            }

        }
    }

    static void output() throws IOException {
        for ( int i = 1; i <= V; i++ ) {
            if ( distance[i] == Integer.MAX_VALUE ) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}



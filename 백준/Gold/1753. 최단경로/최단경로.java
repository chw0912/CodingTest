import java.io.*;
import java.util.ArrayList;
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

        visited = new boolean[V+1];
        distance = new int[V+1];

        for ( int i = 1; i <= V; i++ ) {
            distance[i] = Integer.MAX_VALUE;
        }

    }

    static void solve() {
        distance[K] = 0;

        for ( int i = 0; i < V; i++ ) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for ( int j = 1; j <= V; j++ ) {
                if ( !visited[j] && distance[j] < nodeValue ) {
                    nodeValue = distance[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for ( int j = 0; j < graph.get(nodeIdx).size(); j++ ) {
                Node adjNode = graph.get(nodeIdx).get(j);

                if ( distance[adjNode.index] > distance[nodeIdx] + adjNode.weight ) {
                    distance[adjNode.index] = distance[nodeIdx] + adjNode.weight;
                }
            }
        }
    }

    static void output() throws IOException {
        for ( int i = 1; i <= V; i++ ) {
            if ( distance[i] == Integer.MAX_VALUE ) {
                bw.write("INF\n");
            } else {
                bw.write(String.valueOf(distance[i]) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int T;
    static int N, M; // 책의 개수, 책 빌리러온 학생 수
    static PriorityQueue<Node> pq;
    static boolean[] library;
    static int ans;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());

        for ( int t = 0; t < T; t++ ) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;
            library = new boolean[N+1];
            pq = new PriorityQueue<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if ( o1.end == o2.end ) {
                        return o1.start - o2.start;
                    }
                    return o1.end - o2.end;
                }
            });

            for ( int m = 0; m < M; m++ ) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                Node node = new Node(start, end);
                pq.offer(node);
            }

            solve();
            sb.append(ans).append("\n");
        }

    }

    static void solve() {
        for( int m = 0; m < M; m++ ) {
            Node student = pq.poll();

            for( int book = student.start; book <= student.end; book++ ) {
                if ( !library[book] ) {
                    library[book] = true;
                    ans++;
                    break;
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }

}



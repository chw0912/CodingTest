// G1. 구간 합 구하기

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, K;
    static long[] arr;
    static int command, b, q;
    static long c;
    static StringBuilder sb = new StringBuilder();
    static final int INPUT = 1, OUTPUT = 2;

    static class SegmentTree {
        long[] tree;

        SegmentTree(int N) {
            int h = (int) Math.ceil((Math.log(N)/Math.log(2))) + 1;
            this.tree = new long[(int) Math.pow(2, h)];
        }

        long init(int start, int end, int node) {
            if(start == end) return tree[node] = arr[start];
            int mid = (start + end) / 2;
            return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);
        }

        void update(int start, int end, int node, int idx, long value) {
            if ( start > idx || idx > end ) return;

            tree[node] += value;

            if ( start != end ) {
                int mid = (start + end) / 2;
                update(start, mid, node*2, idx, value);
                update(mid+1, end, (node*2)+1, idx, value);
            }
        }

        long compute(int p, int q, int node, int start, int end) {
            if ( q < start || p > end ) {
                return 0;
            }

            if ( p <= start && end <= q ) {
                return tree[node];
            }
            int mid = (start + end) / 2;

            return compute(p, q,node * 2, start, mid) + compute(p, q,(node*2)+1, mid+1, end);
        }


    }

    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int n = 1; n <= N; n++) {
            arr[n] = Long.parseLong(br.readLine());
        }
        SegmentTree tree = new SegmentTree(N);
        tree.init( 1, N, 1);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            switch (command) {
                case INPUT:
                    c = Long.parseLong(st.nextToken());
                    long diff = c - arr[b];
                    arr[b] = c;
                    tree.update(1, N,1, b, diff);
                    break;

                case OUTPUT:
                    q = Integer.parseInt(st.nextToken());
                    sb.append(tree.compute(b,q,1,1,N)).append("\n");
                    break;
            }

        }
    }

    static void solve() {
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }


}

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, Q;
    static int command, p, x, q;
    static StringBuilder sb = new StringBuilder();
    static final int INPUT = 1, OUTPUT = 2;

    static class SegmentTree {
        long[] tree;

        SegmentTree(int N) {
            int h = (int) Math.ceil((Math.log(N)/Math.log(2))) + 1;
            this.tree = new long[(int) Math.pow(2, h)];
        }

        void update(int start, int end, int node, int idx, int value) {
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
        Q = Integer.parseInt(st.nextToken());
        SegmentTree tree = new SegmentTree(N);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            switch (command) {
                case INPUT:
                    x = Integer.parseInt(st.nextToken());
                    tree.update(1, N,1, p, x);
                    break;
                
                case OUTPUT:
                    q = Integer.parseInt(st.nextToken());
                    sb.append(tree.compute(p,q,1,1,N)).append("\n");

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

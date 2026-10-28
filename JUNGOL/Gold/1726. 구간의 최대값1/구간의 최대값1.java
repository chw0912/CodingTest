// [Gold 3] 1726. 구간의 최대값1

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, Q; // N: 수열의 개수, Q: 질의 개수
    static SegmentTree seg;
    static StringBuilder sb = new StringBuilder();

    public static class SegmentTree {
        int[] tree;

        SegmentTree(int N) {
            int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
            this.tree = new int[(int) Math.pow(2, h)];
        }

        void update(int start, int end, int node, int idx, int value) {
            if (start > idx || idx > end) return;

            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, value);
            update(mid + 1, end, (node * 2) + 1, idx, value);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int compute(int p, int q, int node, int start, int end) {
            if (q < start || p > end) {
                return Integer.MIN_VALUE;
            }

            if (p <= start && end <= q) {
                return tree[node];
            }
            int mid = (start + end) / 2;

            return Math.max(
                    compute(p, q, node * 2, start, mid),
                    compute(p, q, (node*2) + 1, mid + 1, end)
            );
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
        Q = Integer.parseInt(st.nextToken());

        seg = new SegmentTree(N);
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine().trim());
            seg.update(1, N, 1, i, value);
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(seg.compute(a, b, 1, 1, N)).append("\n");
        }
    }

    static void solve()  {

    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] inOrder, postOrder, inOrderIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        inOrder = new int[N+1];
        postOrder = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            inOrder[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            postOrder[n] = Integer.parseInt(st.nextToken());
        }

        inOrderIdx = new int[N+1];
        for (int n = 1; n <= N; n++) {
            inOrderIdx[inOrder[n]] = n;
        }
    }

    static void solve() {
        getPreOrder(1, N, 1, N);
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) return;

        int root = postOrder[postEnd];
        int rIdx = inOrderIdx[root];
        sb.append(root).append(" ");

        int len = rIdx - inStart;

        // left 트리
        getPreOrder(inStart, rIdx - 1, postStart, postStart+len-1);

        // right 트리
        getPreOrder(rIdx+1, inEnd, postStart+len, postEnd-1);
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


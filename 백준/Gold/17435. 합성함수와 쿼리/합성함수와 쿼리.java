import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int m;
    static final int LOG = 19;
    static int Q;
    static int[][] query;
    static int n, x;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        query = new int[LOG+1][m+1];

        for ( int i = 1; i <= m; i++ ) {
            query[0][i] = Integer.parseInt(st.nextToken());
        }

        for ( int i = 1; i <= LOG; i++ ) {
            for ( int j = 1; j <= m; j++ ) {
                int next = query[i-1][j];
                query[i][j] = query[i-1][next];
            }
        }

        Q = Integer.parseInt(br.readLine());

        for ( int q = 0; q < Q; q++ ) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            for ( int i = 0; i <= LOG; i++ ) {
                if( (n & (1 << i)) != 0 ) {
                    x = query[i][x];
                }
            }
            sb.append(x).append("\n");
        }

    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


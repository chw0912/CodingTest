import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static StringBuilder ans = new StringBuilder();
    static int A, B;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        if ( A > B ) {
            ans.append(">");
        } else if ( A < B ) {
            ans.append("<");
        } else {
            ans.append("==");
        }
    }

    static void output() throws IOException {
        bw.write(ans.toString());
        bw.flush();
    }
}

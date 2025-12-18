import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        String str = br.readLine().trim();
        char[] words = str.toCharArray();

        for ( char c : words ) {
            if ( c == ' ' ) {
                ans++;
            }
        }
        if (str.isEmpty()) {
            ans = 0;
        } else {
            ans++;
        }
    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}


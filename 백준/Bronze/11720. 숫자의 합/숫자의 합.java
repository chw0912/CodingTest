import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static char[] number;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        number = new char[N];
        number = br.readLine().toCharArray();
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            ans += number[i] - '0';
        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

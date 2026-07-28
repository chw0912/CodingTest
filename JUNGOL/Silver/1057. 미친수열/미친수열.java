// [Silver 3] 1057. 미친수열

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long N, ans = 1;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Long.parseLong(br.readLine().trim());
    }

    static void solve() {
        for (long i = (long) Math.sqrt(N*2); i < Math.pow(10, 18); i++) {
            long a = (i *(i+1))/2;
            if (a >= N) {
                ans = i;
                break;
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}



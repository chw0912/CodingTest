import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long N, ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
    }

    static void solve() {
        ans = binary_search(N);
    }

    static long binary_search(long n) {
        long left = 1, right = n;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid > n/mid) right = mid - 1;
            else left = mid + 1;
        }

        return left-1;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


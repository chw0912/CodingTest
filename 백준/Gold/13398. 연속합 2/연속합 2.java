import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] numbers; // 1-based
    static int[] dp1, dp2;
    static int ans = -1001;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        dp1 = new int[N+1];
        dp2 = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for ( int n = 1; n <= N; n++ ) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        dp1[0] = ans;

        for ( int i = 1; i <= N; i++ ) {
            dp1[i] = Math.max(dp1[i-1] + numbers[i], numbers[i]);
            ans = Math.max(ans, dp1[i]);
        }

        dp2[N] = numbers[N];

        for ( int i = N-1; i >= 0; i-- ) {
            dp2[i] = Math.max(dp2[i+1]+numbers[i], numbers[i]);
        }

        for ( int i = 1; i < N; i++ ) {
            ans = Math.max(ans, dp1[i-1] + dp2[i+1]);
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}


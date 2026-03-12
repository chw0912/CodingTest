import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long A, B;
    static long[] dp;
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        int len = Long.toBinaryString(B).length();
        dp = new long[len+1];

        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = (dp[i-1] << 1) + (1L << i);
        }
    }

    static void solve() {
        ans = calc(B) - calc(A-1);
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }

    static long calc(long num) {
        long cnt = num & 1; // 1의 개수
        int size = Long.toBinaryString(num).length();

        for (int i = size; i > 0; i--) {
            if ((num & (1L << i)) != 0L) {
                cnt += dp[i-1] + (num - (1L << i) + 1);
                num -= (1L << i);
            }
        }

        return cnt;
    }
}

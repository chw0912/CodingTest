import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] button, lightening; // 스위치, 전구
    static int[] LIS;
    static int[] dp;
    static int len;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        button = new int[N+1];
        lightening = new int[N+1];
        LIS = new int[N+1];
        dp = new int[N+1];

        // 스위치 입력
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            button[j] = Integer.parseInt(st.nextToken());
        }

        // 전구 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lightening[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (button[i] == lightening[j]) {
                    LIS[j] = i;
                }
            }
        }

    }

    static void solve() {

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (LIS[j] < LIS[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            len = Math.max(len, max+1);
            dp[i] = max+1;
        }
        ans = new int[len+1];
        int idx = N;
        for (int i = len; i >= 1; i--) {
            for (int j = idx; j >= 1; j--) {
                if (dp[j] == i) {
                    ans[i] = lightening[j];
                    idx = j-1;
                    break;
                }
            }
        }

        Arrays.sort(ans);

    }

    static void output() throws IOException {
        bw.write(len + "\n");
        for (int i = 1; i <= len; i++) {
            bw.write(ans[i]+" ");
        }
        bw.flush();

    }
}

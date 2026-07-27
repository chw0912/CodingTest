// [Gold 5] 1382. 동전 바꿔주기

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int T; // 지폐의 금액
    static int K; // 동전의 가지 수
    static int[] coin, n; // 동전의 금액, 동전의 개수
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coin = new int[K];
        n = new int[K];

        dp = new int[T+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void solve() {
        dp[0] = 1;
        for (int k = 0; k < K; k++) {
            for (int target = T; target >= coin[k]; target--) {
                for (int amount = 1; amount <= n[k]; amount++) {
                    if (target - (coin[k] * amount) < 0) break;
                    dp[target] += dp[target - (coin[k] * amount)];
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[T]));
        bw.flush();
    }
}
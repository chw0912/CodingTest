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
    static int[] numbers;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[101];
        numbers = new int[N];


        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        String[] add = { "", "" , "1", "7", "4", "2", "0", "8"};

        for ( int i = 9; i <= 100; i++ ) {
            for ( int j = 2; j <= 7; j++ ) {
                String number = dp[i - j] + add[j];
                dp[i] = Math.min(dp[i], Long.parseLong(number));
            }
        }

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {


        for (int i = 0; i < N; i++ ) {
            String maxValue = "";
            if ( numbers[i] % 2 == 0 ) {
                for ( int j = 0; j < numbers[i] / 2; j++ ) {
                    maxValue = maxValue.concat("1");
                }
            } else {
                maxValue = "7";
                for ( int j = 0; j < (numbers[i] / 2) - 1; j++ ) {
                    maxValue = maxValue.concat("1");
                }
            }
            sb.append(dp[numbers[i]]).append(" ").append(maxValue).append("\n");
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

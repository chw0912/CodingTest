// [Gold 2] 1053. 피보나치

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int PISANO = 15 * 1_000;
    static int N;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {

        dp = new int[PISANO + 1];
        dp[1] = 1;

        for (int i = 2; i <= PISANO; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10_000;
        }

        while (true) {
            N = Integer.parseInt(br.readLine().trim());
            if (N < 0) break;

            sb.append(dp[N% PISANO]).append("\n");
        }
    }


    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


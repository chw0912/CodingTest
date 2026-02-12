import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static char[] A, B;
    static int[][] dp;
    static int aLen, bLen;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        String a = br.readLine();
        String b = br.readLine();
        aLen = a.length();
        bLen = b.length();
        A = new char[aLen+1];
        B = new char[bLen+1];
        dp = new int[aLen+1][bLen+1];

        for (int i = 1; i <= aLen; i++) {
            A[i] = a.charAt(i-1);
        }
        for (int i = 1; i <= bLen; i++) {
            B[i] = b.charAt(i-1);
        }

    }

    static void solve() {
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(dp[aLen][bLen] + "\n");
        bw.flush();
    }
}


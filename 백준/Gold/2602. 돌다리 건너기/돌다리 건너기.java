import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int DEVIL = 0, ANGEL = 1;
    static String scroll;
    static String devil;
    static String angel;
    static int[][][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        scroll = br.readLine();
        devil = br.readLine();
        angel = br.readLine();
        dp = new int[2][devil.length()][scroll.length()];
    }

    static void solve() {

        if(devil.charAt(0) == scroll.charAt(0)) {
            dp[DEVIL][0][0] = 1;
        }
        if (angel.charAt(0) == scroll.charAt(0)) {
            dp[ANGEL][0][0] = 1;
        }

        for ( int i = 1; i < angel.length(); i++ ) {
            dp[DEVIL][i][0] = devil.charAt(i) == scroll.charAt(0) ? dp[DEVIL][i-1][0] + 1 : dp[DEVIL][i-1][0];
            for ( int j = 1; j < scroll.length(); j++ ) {
                dp[DEVIL][i][j] = devil.charAt(i) == scroll.charAt(j) ? dp[DEVIL][i-1][j] + dp[ANGEL][i-1][j-1] : dp[DEVIL][i-1][j];
            }

            dp[ANGEL][i][0] = angel.charAt(i) == scroll.charAt(0) ? dp[ANGEL][i-1][0] + 1 : dp[ANGEL][i-1][0];
            for ( int j = 1; j < scroll.length(); j++ ) {
                dp[ANGEL][i][j] = angel.charAt(i) == scroll.charAt(j) ? dp[ANGEL][i-1][j] + dp[DEVIL][i-1][j-1] : dp[ANGEL][i-1][j];
            }
        }

        ans = dp[DEVIL][devil.length()-1][scroll.length()-1] + dp[ANGEL][angel.length()-1][scroll.length()-1];
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}


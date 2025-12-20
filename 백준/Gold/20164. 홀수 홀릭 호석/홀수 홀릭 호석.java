import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static String N;
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = br.readLine();
    }

    static void solve() {
        dfs(N,0);
        sb.append(min).append(" ").append(max);
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }

    // 홀수 판별
    static boolean isOdd(int x) {
        return x % 2 != 0;
    }

    static void dfs(String s, int ans) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int plus = 0;

        for ( char c : chars ) {
            if ( isOdd(c) ) {
                plus++;
            }
        }

        if ( len == 1 ) {
            if ( isOdd(Integer.parseInt(s)) ) ans++;
            min = Math.min(min, ans);
            max = Math.max(max, ans);
            return;
        }

        // 2분할
        if ( len == 2 ) {
            int temp = Integer.parseInt(s);
            int s1 = temp/10;
            int s2 = temp%10;

            dfs(String.valueOf(s1+s2), ans+plus);

        }

        // 3분할
        if ( len >= 3 ) {
            for ( int i = 1; i <= len-2; i++ ) {
                for ( int j = i+1; j <= len-1; j++ ) {
                    int s1 = Integer.parseInt(s.substring(0, i));
                    int s2 = Integer.parseInt(s.substring(i, j));
                    int s3 = Integer.parseInt(s.substring(j));

                    dfs(String.valueOf(s1+s2+s3), ans+plus);
                }
            }
        }

    }
}

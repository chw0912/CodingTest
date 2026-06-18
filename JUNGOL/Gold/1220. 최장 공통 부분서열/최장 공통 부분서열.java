import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static char[] chars1, chars2;
    static int[][] LCS;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        chars1 = br.readLine().toCharArray();
        chars2 = br.readLine().toCharArray();
        LCS = new int[chars1.length+1][chars2.length+1];
    }

    static void solve() {
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    LCS[i][j] = LCS[i - 1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(LCS[chars1.length][chars2.length] + "\n");
        bw.flush();
    }
}

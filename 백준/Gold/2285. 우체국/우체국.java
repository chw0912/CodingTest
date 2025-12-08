import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static long[][] village;
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        village = new long[N][2];
        for ( int n = 0; n < N; n++ ) {
            st = new StringTokenizer(br.readLine());

            village[n][0] = Long.parseLong(st.nextToken());
            village[n][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(village, Comparator.comparing(a -> a[0]));
    }

    static void solve() {
        long total = 0;
        for ( int i = 0; i < N; i++ ) {
            total += village[i][1];
        }

        long mid = (total+1)/2;

        long people = 0;
        for ( int i = 0; i < N; i++ ) {
            people += village[i][1];
            if ( people >= mid ) {
                ans = village[i][0];
                break;
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

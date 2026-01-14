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
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for ( int n = 0; n < N; n++ ) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        for (int n = 0; n < N; n++ ) {
            sb.append(arr[n]).append("\n");
        }
    }

    static void solve() {
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


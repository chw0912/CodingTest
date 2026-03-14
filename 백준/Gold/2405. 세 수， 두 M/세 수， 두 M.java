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
    static int[] A;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
    }

    static void solve() {
        for (int i = 1; i < N-1; i++) {
            int avg = A[0] + A[i] + A[i+1];
            ans = Math.max(ans, Math.abs(avg - 3*A[i]));
        }

        for (int i = 0; i < N-2; i++) {
            int avg = A[i] + A[i+1] + A[N-1];
            ans = Math.max(ans, Math.abs(avg - 3*A[i+1]));
        }

    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}


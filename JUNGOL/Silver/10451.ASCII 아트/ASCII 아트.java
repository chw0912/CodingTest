import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long T, N;
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        input();
//        solve();
//        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Long.parseLong(br.readLine());
            int x = 0;

            while (26L *(x+1) < N) {
                x++;
                N -= (26L * x);
            }

            long div = (N-1) / (x+1);

            bw.write("Case #"+ t + ": " + alphabet.charAt((int) div)+"\n");
            bw.flush();
        }
    }

//    static void solve() {
//
//    }
//
//    static void output() throws IOException {
//
//    }
}


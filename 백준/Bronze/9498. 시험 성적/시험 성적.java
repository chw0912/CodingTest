import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int score;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        score = Integer.parseInt(br.readLine());
    }

    static void solve() {
        if ( score >= 90 ) {
            sb.append("A");
        } else if( score >= 80 ) {
            sb.append("B");
        } else if( score >= 70 ) {
            sb.append("C");
        } else if( score >= 60 ) {
            sb.append("D");
        } else {
            sb.append("F");
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }

}


// [Gold 5] 1262. 긴 자리 곱셈

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static BigInteger N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {


        while (true) {
            st = new StringTokenizer(br.readLine());
            N = new BigInteger(st.nextToken());
            if (!st.hasMoreTokens()) break;

            M = new BigInteger(st.nextToken());
            sb.append(N.multiply(M)).append('\n');
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}

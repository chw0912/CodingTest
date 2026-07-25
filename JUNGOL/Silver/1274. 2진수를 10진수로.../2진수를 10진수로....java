// [Silver 1] 1274. 2진수를 10진수로...

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static Integer ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        String str = br.readLine();

        int val = Integer.parseInt(str, 2);
        // 최상의 부호 비트가 1일 경우
        // 256을 빼준다.
        if ((val & 0x80) != 0) {
            val -= 256;
        }
        ans = val;
    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


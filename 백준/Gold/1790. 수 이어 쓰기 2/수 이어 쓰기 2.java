import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long N, K;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        // 현재 자릿 수(1, 2, 3...)
        int digit = 1;
        // 해당 자릿 수의 총 개수 (9, 90, 900...)
        long valueCount = 9;

        while (K > digit * valueCount) {
            K -= digit * valueCount;
            digit++;
            valueCount *= 10;
        }

        long startNum = 1;
        for (int i = 1; i < digit; i++) {
            startNum *= 10;
        }

        long targetNum = startNum + ((K-1) / digit);

        if (targetNum > N) return;

        String targetStr = String.valueOf(targetNum);
        int idx = (int) ((K-1) % digit);

        ans = targetStr.charAt(idx) - '0';
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

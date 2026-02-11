import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static char[] chars;
    static int rCnt, bCnt; // 색깔 별 총 개수
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        chars = new char[N];
        ans = N;
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);

            if (c == 'R') rCnt++;
            else bCnt++;
            chars[i] = c;
        }
    }

    static void solve() {
        // 1. R을 왼쪽으로 모으기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'R') cnt++;
            else break;
        }
        ans = Math.min(ans, rCnt - cnt);

        // 2. R을 오른쪽으로 모으기
        cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if (chars[i] == 'R') cnt++;
            else break;
        }
        ans = Math.min(ans, rCnt - cnt);

        // 3. B를 왼쪽으로 모으기
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == 'B') cnt++;
            else break;
        }
        ans = Math.min(ans, bCnt - cnt);

        // 4. B를 오른쪽으로 모으기
        cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if (chars[i] == 'B') cnt++;
            else break;
        }
        ans = Math.min(ans, bCnt - cnt);
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

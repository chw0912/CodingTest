import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static long X, Y;
    static int MOD = 20_091_024;
    static int ans;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
    }

    static void solve() {
        if (X == 0 && Y == 0) {
            ans = 1;
            return;
        }
        ans = (int) power(X, Y);
    }

    // 분할 정복을 이용한 거듭제곱 메서드
    static long power(long base, long exp) {
        long result = 1;
        base = base % MOD; // 처음 base 값도 MOD로 한 번 나눠줍니다.

        while (exp > 0) {
            // 지수가 홀수일 때만 결과에 base를 곱해줍니다.
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            // base를 제곱하고 지수를 절반으로 줄입니다.
            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int W, balance, ans;
    static int[] amount; // 500, 100, 50, 10, 5, 1
    static int[] coin = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        W = Integer.parseInt(br.readLine());
        amount = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
            ans += amount[i];
            balance += amount[i] * coin[i];
        }

    }

    static void solve() {
        balance -= W;

        for (int i = 0; i < coin.length; i++) {
            if (amount[i] == 0) continue;

            for (int j = amount[i]; j >= 1; j--) {
                if (balance - coin[i] * j >= 0) {
                    balance -= coin[i] * j;
                    ans -= j;
                    amount[i] -= j;
                    break;
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");

        for (int n : amount) bw.write(n + " ");
        bw.newLine();
        bw.flush();
    }
}

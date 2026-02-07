import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int LIMIT_PLAYER = 11, LIMIT_VALUE = 100_000;
    static int N, K;
    static int[][] team = new int[12][100_001];
    static int[] player = new int[12];
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            team[position][value] += 1;
            if (value > player[position]) {
                player[position] = value;
            }
        }

    }

    static void solve() {
        while (K-- > 0) {
            for (int i = 1; i <= LIMIT_PLAYER; i++) {
                if (player[i] != 0) {
                    team[i][player[i]]--;
                    team[i][player[i]-1]++;
                    if (team[i][player[i]] == 0) {
                        player[i]--;
                    }
                }
            }
        }

        for (int i = 1; i <= LIMIT_PLAYER; i++) {
            ans += player[i];
        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

// [Silver 1] 1127. 맛있는 음식(PERKET)

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] S, B;
    static int ans = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        dfs(0,1,0,0);
    }

    static void dfs(int idx, int s, int b, int cnt) {

        if (idx == N) {
            if (cnt > 0) {
                int diff = Math.abs(s - b);
                ans = Math.min(ans, diff);
            }
            return;
        }
        // 재료를 선택한 경우
        dfs(idx+1, s*S[idx], b+B[idx], cnt+1);
        // 재료를 선택하지 않은 경우
        dfs(idx+1, s, b, cnt);
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


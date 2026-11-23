// [Gold 4] 1107. 리모컨

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;

    static int target, min;
    static boolean[] btn = { true, true, true, true, true, true, true, true, true, true };

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        target = Integer.parseInt(br.readLine());

        int broken = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;

        if (broken != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < broken; i++) {
                btn[Integer.parseInt(st.nextToken())] = false;
            }

        }
    }

    static void solve() {

        // 타겟이 100번인 경우
        if (target == 100) {
            min = 0;
            return;
        }

        // 타겟이 100번 채널에서 +,-로만 이동
        int cnt = Math.abs(100 - target);
        min = min > cnt ? cnt : min;

        // 모든 경우의 버튼 누르기
        dfs(0, "");
    }

    static void output() throws IOException {
        bw.write(min + "\n");
        bw.flush();

    }

    public static void dfs(int idx, String click) {
        for (int i = 0; i < 10; i++) {
            if (btn[i]) {
                String newStr = click + i;
                int cnt = Math.abs(target - Integer.parseInt(newStr)) + newStr.length();
                min = Math.min(min, cnt);
                if (idx < 6) {
                    dfs(idx+1, newStr);
                }
            }
        }
    }
}

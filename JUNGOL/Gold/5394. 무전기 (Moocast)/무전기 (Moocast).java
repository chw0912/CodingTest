// [Gold 4] 5394. 무전기

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, ans;
    static boolean[] visited;
    static Soldier[] soldiers;


    public static class Soldier {
        int x, y, p;

        public Soldier(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        soldiers = new Soldier[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            soldiers[i] = new Soldier(x, y, p);
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            int possible = dfs(i);

            if (possible > ans) {
                ans = possible;
            }
        }
    }

    static int dfs(int curIdx) {
        visited[curIdx] = true;
        int cnt = 1;

        Soldier cur = soldiers[curIdx];

        for (int nextIdx = 0; nextIdx < N; nextIdx++) {
            if (!visited[nextIdx]) {
                Soldier next = soldiers[nextIdx];

                int dist = (int) (Math.pow(cur.x - next.x,2) + Math.pow(cur.y - next.y, 2));
                int p = (int) Math.pow(cur.p, 2);

                if (dist <= p) {
                    cnt += dfs(nextIdx);
                }
            }
        }

        return cnt;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


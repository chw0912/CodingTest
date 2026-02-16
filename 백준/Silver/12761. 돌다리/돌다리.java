// S1. 돌다리

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int LIMIT = 100_000;
    static int A, B, N, M;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[LIMIT+1];
    }

    static void solve() {
        dq.offer(new int[] {N, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curPos = cur[0];
            int curMove = cur[1];

            if (curPos == M) {
                ans = curMove;
                return;
            }

            int[] nextPos = new int[] {
                    curPos + 1, curPos - 1,
                    curPos + A, curPos - A,
                    curPos + B, curPos - B,
                    curPos * A, curPos * B
            };

            for (int next : nextPos) {
                if (next < 0 || next > LIMIT) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    dq.offer(new int[] {next, curMove+1});
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}


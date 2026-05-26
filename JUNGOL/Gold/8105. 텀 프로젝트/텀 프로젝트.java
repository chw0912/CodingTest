// G3. 텀 프로젝트
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, ans;
    static int[] S;
    static boolean[] visited, done;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        S = new int[N+1];
        done = new boolean[N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!done[i]) {
                dfs(i);
            }
        }
    }

    static void dfs(int cur) {

        if (visited[cur]) {
            done[cur] = true;
            ans++;
        } else {
            visited[cur] = true;
        }

        if (!done[S[cur]]) {
            dfs(S[cur]);
        }

        visited[cur] = false;
        done[cur] = true;

    }

    static void output() throws IOException {
        bw.write((N-ans) + "\n");
        bw.flush();
    }
}


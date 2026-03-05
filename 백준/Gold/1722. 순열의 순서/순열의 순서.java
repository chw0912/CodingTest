import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int command, data; // 명령어, 임의의 순열 데이터
    static long order; // 순서

    static boolean[] visited;
    static long[] factorial;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        // 방문처리
        visited = new boolean[N+1];
        // 팩토리얼
        factorial = new long[N];
        factorial[0] = 1;
        for (int i = 1; i < N; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        st = new StringTokenizer(br.readLine());
        // 명령어
        command = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        if (command == 1) {
            // 순서
            order = Long.parseLong(st.nextToken()) - 1;
            for (int i = N-1; i >= 0; i--) {
                long tmp = order / factorial[i] + 1;
                order %= factorial[i];
                long cnt = 0;
                int idx = 0;
                while (cnt != tmp) {
                    idx++;
                    if (!visited[idx]) cnt++;
                }
                visited[idx] = true;
                sb.append(idx).append(" ");
            }
        } else {
            // 임의의 순서
            long tmp = 1;
            for (int i = N-1; i >= 0; i--) {
                data = Integer.parseInt(st.nextToken());
                int idx = 0;
                int cnt = 0;
                while (idx != data) {
                    idx++;
                    if (!visited[idx]) cnt++;
                }
                visited[idx] = true;
                tmp += (cnt - 1) * factorial[i];
            }
            sb.append(tmp);
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}

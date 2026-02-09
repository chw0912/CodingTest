import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static int[] result;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int MAX_VALUE = 100_001;
    static int INF = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
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

        result = new int[MAX_VALUE];
        Arrays.fill(result, INF);
    }

    static void solve() {
        bfs();
    }

    static void output() throws IOException {
        bw.write(min+"\n");
        bw.write(ans+"\n");
        bw.flush();
    }

    static void bfs() {
        dq.add(N);
        result[N] = 0;

        while (!dq.isEmpty()) {
            int x = dq.poll();

            // 현재 시간이 이미 구해진 최소 시간보다 크면 pass
            if (min < result[x]) continue;

            if (x == K) {
                if (result[x] < min) {
                    min = result[x];
                    ans = 1;
                } else if (result[x] == min) {
                    ans++;
                }
                continue;
            }

            int[] nextMoves = {x-1, x+1, x*2};

            for (int next : nextMoves) {
                if (next >= 0 && next < MAX_VALUE) {
                    // 방문하지 않았거나(INF),
                    // 이미 방문했지만 현재 경로로 도달하는 시간이 동일할 경우(result[next] == result[x] + 1)
                    // 큐에 추가하여 경로의 수를 계산
                    if (result[next] == INF || result[next] == result[x] + 1) {

                        // 다음 위치 시간 = 현재 위치 시간 + 1
                        result[next] = result[x] + 1;
                        dq.add(next);
                    }
                }
            }
        }
    }
}


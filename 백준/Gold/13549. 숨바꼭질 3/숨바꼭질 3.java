import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K; // 수빈 위치, 동생 위치
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static int[] result;
    static int MAX_VALUE = 100_001;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = new int[K*2 +1];

        for (int i = 0; i <= K*2; i++) {
            result[i] = INF;
        }

    }

    static void solve() {

        // 만약 수빈이의 위치가 동생 위치보다 앞에 있다면
        // 수빈이의 위치 - 동생 위치
        // 이 값이 최소가 된다.
        if ( N > K ) {
            result[K] = N - K;
            return;
        }
        queue.add(N);
        result[N] = 0;

        while (!queue.isEmpty()) {
            // 현재 수빈 위치
            int x = queue.poll();

            // 만약 현재 위치가 K라면 이동 금지
            if (x == K) {
                continue;
            }

            // 만약 현재 x 위치가 K가 아니라면 x-1, x+1 추가
            // x-1, x+1의 값이 정해진 범위 내일 경우
            // 가장 빠른 값이 있을 때 queue에 위치 추가
            if ( x - 1 >= 1) {
                if ( result[x-1] > result[x] + 1 ) {
                    queue.add(x-1);
                    result[x-1] = result[x] + 1;
                }
            }
            if ( x+1 < MAX_VALUE) {
                if ( result[x+1] > result[x] + 1 ) {
                    queue.add(x+1);
                    result[x+1] = result[x] + 1;
                }
            }

            // 만약 순간이동이 K를 넘지 않는다면
            if ( x*2 < K ) {
                // queue에 순간이동 위치(x*2)를 추가 및 이동 최소값 구하기
                if ( result[x*2] > result[x] ) {
                    queue.add(x*2);
                    result[x*2] = result[x];
                }
            } else {
                // 순간이동 위치가 K를 넘으면
                // 현재 좌표(result[x])와
                // 순간이동한 위치 - 동생의 위치(K) 값을 뺀 만큼의 시간을 더하여
                // 최소값을 구한다
                result[K] = Math.min(result[K], result[x] + (x*2) - K);
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(result[K]));
        bw.flush();
        bw.close();
    }
}

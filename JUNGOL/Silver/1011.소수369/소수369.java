import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] player;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        player = new int[N];
        isPrime = new boolean[N];
    }

    static void solve() {
        getPrimes();
        int idx = 0;

        for (int i = 1; i <= M; i++) {
            if (isPrime[i]) player[idx]++;

            idx++;
            if (idx == N) idx = 0;
        }
    }

    static void getPrimes() {
        isPrime = new boolean[M + 1]; // 인덱스를 M까지 편하게 쓰기 위해 +1 크기로 생성

        // 1. 처음엔 2부터 M까지 모두 소수(true)라고 가정합니다.
        for (int i = 2; i <= M; i++) {
            isPrime[i] = true;
        }

        // 2. 소수의 배수들을 걸러냅니다. (i의 제곱근까지만 검사해도 충분합니다)
        for (int i = 2; i * i <= M; i++) {
            if (isPrime[i]) {
                // i가 소수라면, i의 배수들은 모두 소수가 아니므로 false로 바꿉니다.
                for (int j = i * i; j <= M; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    static void output() throws IOException {
        bw.write(player[K] + "\n");
        bw.flush();
    }
}

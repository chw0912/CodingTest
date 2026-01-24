// G5. 두 배 더하기

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] B;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        while (true) {
            // 1. 모든 수가 0인지 확인하고, 홀수가 있으면 처리
            int zeroCount = 0;
            for (int i = 0; i < N; i++) {
                if (B[i] % 2 == 1) { // 홀수라면
                    B[i]--;         // 1을 빼서 짝수로 만듦
                    ans++;            // 연산 횟수 증가
                }

                if (B[i] == 0) {
                    zeroCount++;
                }
            }

            // 모든 요소가 0이 되면 종료
            if (zeroCount == N) break;

            // 2. 모든 수를 2로 나눔 (이 연산은 전체에 대해 1번만 카운트)
            for (int i = 0; i < N; i++) {
                B[i] /= 2;
            }
            ans++;
        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }


}

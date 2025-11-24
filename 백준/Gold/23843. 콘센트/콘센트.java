import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // 전자기기 개수, 콘센트 개수
    static int[] elects; // 전자기기 충전시간
    static int[] concent; // 콘센트

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        elects = new int[N];
        concent = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            elects[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(elects);
    }

    static void solve() {

        // 전자기기 인덱스
        int electIdx = N - 1;

        // 콘센트 인덱스
        int concentIdx = 0;
        // 전자기기를 하나씩 체크
        device:
        while (electIdx >= 0) {
            // 이전 콘센트 > 현재 콘센트
            while (concentIdx != M) {
                if (concent[(concentIdx - 1 + M) % M] > concent[concentIdx]) {
                    concent[concentIdx] += elects[electIdx--];
                    continue device;
                } else {
                    concentIdx += 1;
                }
            }
            // 못찾았을때
            concentIdx = 0;
            concent[concentIdx++] += elects[electIdx--];
        }
    }

    static void output() throws IOException {
        int result = 0;

        for (int i = 0; i < M; i++) {
            if ( result < concent[i] ) {
                result = concent[i];
            }
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}

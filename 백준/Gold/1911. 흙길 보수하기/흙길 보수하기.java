import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, L;
    static int[][] pool;
    static int poolSize;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        pool = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pool[i][0] = start;
            pool[i][1] = end;
            if (end > poolSize) {
                poolSize = end;
            }
        }

        Arrays.sort(pool, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

    }

    static void solve() {
        // 보수하기
        int index = 0;

        for (int i = 0; i < N; i++) {
            int start = pool[i][0];
            int end = pool[i][1];

            // index가 end보다 크면 다음으로 넘어가기
            if (end < index) {
                continue;
            }

            // index가 길 전체 크기보다 크면 탈출
            if (index > poolSize) {
                break;
            }

            // 시작점이 start보다 크면 start는 index로 변경
            if (start < index) {
                start = index;
            }

            // 널판지 사용량
            int plank = 0;
            if ((end-start)%L != 0) {
                plank = (end - start)/L + 1;
            } else {
                plank = (end - start)/L;
            }
            ans += plank;
            index = start + (L * plank);

        }

    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

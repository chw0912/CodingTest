import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N; // 회의 수
    static int[][] reserve; // 회의실 예약 정보
    static int result = 1; // 출력값
    static int end = 0;



    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        reserve = new int[N+1][2];

        for ( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            reserve[i][0] = Integer.parseInt(st.nextToken());
            reserve[i][1] = Integer.parseInt(st.nextToken());
        }
        // 회의 종료 시간을 기준으로 정렬
        Arrays.sort(reserve, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

    }

    static void solve() throws IOException {
        end = reserve[1][1];

        for ( int i = 2; i <= N; i++ ) {
            int start = reserve[i][0];
            int close = reserve[i][1];

            if (end <= start) {
                end = close;
                result++;
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // 구슬의 개수, 저울에 올려 본 쌍의 개수
    static boolean[][] arr; // 1-based
    static int result = 0;
    static int MID;

    // 플로이드 워셜 알고리즘 적용
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MID = (N + 1) / 2;
        arr = new boolean[N+1][N+1];

        for ( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }


    }

    static void solve() {
        floyd();


        for ( int i = 1; i <= N; i++ ) {
            int heavy = 0;
            int small = 0;


            for ( int j = 1; j <= N; j++ ) {
                if ( arr[i][j] ) {
                    heavy++;
                }
                if ( arr[j][i] ) {
                    small++;
                }
            }
            if ( heavy >= MID || small >= MID ) {
                result++;
            }
        }

    }

    static void output() throws IOException {
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void floyd() {
        for ( int k = 1; k <= N; k++ ) {
            for ( int i = 1; i <= N; i++ ) {
                for ( int j = 1; j <= N; j++ ) {
                    if ( arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
    }

}

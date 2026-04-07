// G4. 사탕 줍기 대회

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int M, N;
    static int[][] map;
    static int ans;
//    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
//        solve();
//        output();
    }

    static void input() throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(M == 0 && N == 0) break;

            map = new int[M+1][N+1];

            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 1; n <= N; n++) {
                    map[m][n] = Integer.parseInt(st.nextToken());
                }
            }

            ans = solve();
            output();
        }

    }

    static int solve() {

        int[] row = new int[M + 1];

        for(int i = 1; i <= M; i++) {
            int[] dpRow = new int[N + 1];

            dpRow[1] = map[i][1];

            for(int j = 2; j <= N; j++) {
                dpRow[j] = Math.max(dpRow[j-1], dpRow[j-2] + map[i][j]);
            }

            row[i] = dpRow[N];
        }

        int[] dpCol = new int[M + 1];

        dpCol[1] = row[1];

        for(int i = 2; i <= M; i++) {
            dpCol[i] = Math.max(dpCol[i-1], dpCol[i-2] + row[i]);
        }
        return dpCol[M];
    }


    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

}


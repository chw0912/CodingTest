import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int max = 0, min = Integer.MAX_VALUE;
    static int[][] minMap, maxMap;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minMap = new int[N][3];
        maxMap = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minMap[i], min);
        }
    }

    static void solve() {

        minMap[0] = map[0];
        maxMap[0] = map[0];

        for (int i = 1; i < N; i++) {
            // min
            minMap[i][0] = Math.min(minMap[i-1][0]+map[i][0], minMap[i-1][1]+map[i][0]);
            minMap[i][1] = Math.min(minMap[i-1][0]+map[i][1], Math.min(minMap[i-1][1]+map[i][1], minMap[i-1][2]+map[i][1]));
            minMap[i][2] = Math.min(minMap[i-1][1]+map[i][2], minMap[i-1][2]+map[i][2]);

            // max
            maxMap[i][0] = Math.max(maxMap[i-1][0]+map[i][0], maxMap[i-1][1]+map[i][0]);
            maxMap[i][1] = Math.max(maxMap[i-1][0]+map[i][1], Math.max(maxMap[i-1][1]+map[i][1], maxMap[i-1][2]+map[i][1]));
            maxMap[i][2] = Math.max(maxMap[i-1][1]+map[i][2], maxMap[i-1][2]+map[i][2]);
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxMap[N-1][i]);
            min = Math.min(min, minMap[N-1][i]);
        }
    }

    static void output() throws IOException {
        bw.write(max + " " + min + "\n");
        bw.flush();
    }

}


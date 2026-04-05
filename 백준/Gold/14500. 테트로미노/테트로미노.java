import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void solve() {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // ㅁ
                if(i + 1< N && j + 1 < M) {
                    int temp = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                    if(ans < temp) ans = temp;
                }

                // ㅡ
                if(j + 3 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    if(ans < temp) ans = temp;
                }

                // ㅣ
                if(i + 3 < N) {
                    int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    if(ans < temp) ans = temp;
                }

                // ㅏ
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                    if(ans < temp) ans = temp;
                }

                // ㅓ
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
                    if(ans < temp) ans = temp;
                }

                // ㅗ
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
                    if(ans < temp) ans = temp;
                }

                // ㅜ
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                    if(ans < temp) ans = temp;
                }

                // L
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j] + map[i+1][j]+ map[i+2][j] + map[i+2][j+1];
                    if(ans < temp) ans = temp;
                }

                // L 반전
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j+1] + map[i+1][j+1]+ map[i+2][j+1] + map[i+2][j];
                    if(ans < temp) ans = temp;
                }

                // L 회전
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2];
                    if(ans < temp) ans = temp;
                }

                // L 회전, 반전
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    if(ans < temp) ans = temp;
                }

                // ㄱ
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                    if(ans < temp) ans = temp;
                }

                // ㄱ 반전
                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                    if(ans < temp) ans = temp;
                }

                // ㄱ 회전
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
                    if(ans < temp) ans = temp;
                }

                // ㄱ 회전,반전
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    if(ans < temp) ans = temp;
                }

                // Z
                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    if(ans < temp) ans = temp;
                }

                if(i + 2 < N && j + 1 < M) {
                    int temp = map[i+1][j] + map[i+2][j] + map[i][j+1] + map[i+1][j+1];
                    if(ans < temp) ans = temp;
                }

                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    if(ans < temp) ans = temp;
                }

                if(i + 1 < N && j + 2 < M) {
                    int temp = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
                    if(ans < temp) ans = temp;
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, R;
    static int[][] A;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static ArrayDeque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for ( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0; j < M; j++ ) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {

        int xE = N;
        int yE = M;
        int start = 0;


        while ((xE-start) > 0 && (yE-start) > 0) {


            int tE = totalElements(start, xE, yE);
            int[] arr = new int[tE];
            bfs(arr, start, xE, yE);

            // 회전 횟수
            int r = R % tE;

            rotate(start, xE, yE, arr, r, tE);
            start++;
            xE--;
            yE--;
        }


    }

    static void bfs(int[] arr, int start, int xE, int yE) {

        dq.offer(new int[] {start, start});
        int dir = 0;
        int idx= 0;

        while ( !dq.isEmpty() ) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            arr[idx] = A[x][y];

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어난 경우 방향 틀기
            if ( start > nx || nx >= xE || start > ny || ny >= yE) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            if(nx != start || ny != start) {
                dq.offer(new int[] {nx, ny});
                idx++;
            }
        }
    }

    static void output() throws IOException {
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < M; j++ ) {
                bw.write(A[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static int totalElements(int start, int xE, int yE) {
        if ( xE - start > 1  && yE - start > 1) {
            return ((xE-start)*2 + (yE-start)*2 - 4);
        } else {
            return ((xE - start) * (yE -start));
        }
    }

    static void rotate(int start, int xE, int yE, int[] arr, int idx, int tE) {

        // 이동할 방향
        int dir = 0;

        dq.offer(new int[] {start, start});
        A[start][start] = 0;

        while ( !dq.isEmpty() ) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어난 경우 방향 틀기
            if ( start > nx || nx >= xE || start > ny || ny >= yE) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            if ( nx != start || ny != start ) {
                A[x][y] = arr[idx];
                idx = (idx + 1) % tE;
                dq.offer(new int[] {nx, ny});
            } else {
                A[x][y] = arr[idx];
            }
        }

    }
}


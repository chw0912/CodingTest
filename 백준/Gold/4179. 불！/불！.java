// G3. 불!

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C;
    static char[][] map;
    static Queue<int[]> personQ, fireQ;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        personQ = new LinkedList<>();
        fireQ = new LinkedList<>();

        for ( int r = 0; r < R; r++ ) {
            String line = br.readLine();
            for ( int c = 0; c < C; c++ ) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'J') {
                    personQ.offer(new int[] {r,c,0});
                } else if (map[r][c] == 'F') {
                    fireQ.offer(new int[] {r,c});
                }
            }
        }

    }

    static void solve() {
        ans = -1;
        out: while(true) {
            int fSize = fireQ.size();
            for ( int i = 0; i < fSize; i++ ) {
                int[] fire = fireQ.poll();
                spread(fire[0], fire[1]);
            }
            int pSize = personQ.size();
            for ( int i = 0; i < pSize; i++ ) {
                int[] person = personQ.poll();
                ans = move(person[0], person[1], person[2]);
                if (ans != -1) break out;
            }
            if (personQ.isEmpty()) break;
        }
    }

    static void output() throws IOException {
        if ( ans == -1 ) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(ans));
        }
        bw.flush();
    }

    // 지훈이 이동
    static int move(int x, int y, int dist) {
        for ( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( nx < 0 || ny < 0 || nx >= R || ny >= C ) {
                return dist+1;
            }

            if ( map[nx][ny] == '.' ) {
                map[nx][ny] = 'J';
                personQ.offer(new int[] {nx, ny, dist +1});
            }
        }

        return -1;
    }

    // 지훈이 이동
    // 불 확산
    static void spread(int x, int y) {
        for ( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( nx < 0 || ny < 0 || nx >= R || ny >= C ) continue;


            if ( map[nx][ny] == '.' || map[nx][ny] == 'J') {
                map[nx][ny] = 'F';
                fireQ.offer(new int[] {nx, ny});
            }
        }
    }


}

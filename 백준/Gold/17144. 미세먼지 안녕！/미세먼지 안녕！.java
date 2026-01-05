import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C, T;
    static int[][] map;
    static int air;
    // 위 공기청정기 기준 이동 좌표
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {

        // 압력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for ( int r = 0; r < R; r++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int c = 0; c < C; c++ ) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기청정기 찾기
        for ( int r = 0; r < R; r++ ) {
            if ( map[r][0] == -1 ) {
                air = r;
                break;
            }
        }


    }

    static void solve() {
        while (T-->0) {
            int[][] newMap = new int[R][C];
            newMap[air][0] = -1;
            newMap[air+1][0]= -1;

            for ( int r = 0; r < R; r++ ) {
                for ( int c = 0; c < C; c++ ) {
                    if ( map[r][c] > 0 ) diffusion(r, c, newMap);
                }
            }


            operation(air, newMap);
            operation(air+1, newMap);
            
            map = newMap;
        }

        for ( int r = 0; r < R; r++ ) {
            for ( int c = 0; c < C; c++ ) {
                ans += map[r][c];
            }
        }
        ans += 2;
    }

    static void output() throws IOException {
//        for ( int i = 0; i < R; i++ ){
//            for ( int j = 0; j < C; j++ ) {
//                bw.write(map[i][j] + " ");
//            }
//            bw.write("\n");
//        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    // 확산
    static void diffusion(int x, int y, int[][] newMap) {

        int amount = amountSpread(x, y);

        for ( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1 && map[x][y] > 0 ) {
                newMap[nx][ny] += amount;
                map[x][y] -= amount;
            }
        }
        newMap[x][y] += map[x][y];
    }

    // 확산되는 양
    static int amountSpread(int x, int y) {
        return map[x][y] / 5;
    }

    // 공기청정기 작동
    static void operation(int machine, int[][] newMap) {

        // 아래쪽 공기청정기일 경우
        if ( machine == air ) {
            int dir = 0;
            dq.offer( new int[]{machine + dx[dir], 0} );
            while( !dq.isEmpty() ) {
                int[] cur = dq.poll();

                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                // 범위를 벗어난 경우
                // 방향 전환
                if ( nx < 0 || nx > machine || ny < 0 || ny >= C ) {
                    dir = (dir + 1) % 4;
                    nx = cur[0] + dx[dir];
                    ny = cur[1] + dy[dir];
                }

                // 공기청정기를 만났을 때
                // 종료와 함께 0으로 초기화
                if ( map[nx][ny] == -1 ) {
                    newMap[cur[0]][cur[1]] = 0;
                    return;
                }

                // 한칸씩 이동
                newMap[cur[0]][cur[1]] = newMap[nx][ny];
                dq.offer(new int[] {nx, ny});

            }
        } else {
            int dir = 0;
            dq.offer( new int[]{machine + (-1*dx[dir]), 0} );
            while( !dq.isEmpty() ) {
                int[] cur = dq.poll();

                int nx = cur[0] + (-1 * dx[dir]);
                int ny = cur[1] + dy[dir];

                // 범위를 벗어난 경우
                // 방향 전환
                if ( nx < air+1 || nx >= R || ny < 0 || ny >= C ) {
                    dir = (dir + 1) % 4;
                    nx = cur[0] + (-1 * dx[dir]);
                    ny = cur[1] + dy[dir];
                }

                // 공기청정기를 만났을 때
                // 종료와 함께 0으로 초기화
                if ( map[nx][ny] == -1 ) {
                    newMap[cur[0]][cur[1]] = 0;
                    return;
                }

                // 한칸씩 이동
                newMap[cur[0]][cur[1]] = newMap[nx][ny];
                dq.offer(new int[] {nx, ny});

            }
        }

    }

}


import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, K;
    static ArrayList<FireBall>[][] map;
    static ArrayList<FireBall> balls = new ArrayList<>();
    static ArrayDeque<FireBall> dq = new ArrayDeque<>();
    static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int ans;

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];

        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                map[i][j] = new ArrayList<>();
            }
        }

        for ( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            FireBall ball = new FireBall(r,c,m,s,d);
            map[r][c].add(ball);
            balls.add(ball);
        }

    }

    static void solve() {
        while(K-->0) {
            move();

            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < N; j++ ) {
                    if ( map[i][j].size() >= 2 ) {
                        magic(i, j);
                    }
                }
            }

            clean();
        }

        for ( FireBall ball : balls ) {
            ans += ball.m;
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    // 파이어볼 초기화
    static void clean() {
        balls.clear();
        for (int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                if (!map[i][j].isEmpty()) {
                    balls.addAll(map[i][j]);
                }
            }
        }
    }

    // 자신의 방향 d로 속력 s칸 만큼 이동
    static void move() {
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                map[i][j].clear();
            }
        }

        for ( FireBall cur : balls ) {
            int nx = (cur.r + N + dx[cur.d] * (cur.s%N)) % N;
            int ny = (cur.c + N + dy[cur.d] * (cur.s%N)) % N;

            cur.r = nx;
            cur.c = ny;
            map[nx][ny].add(cur);
        }
    }

    // 해당 칸에 파이어볼이 2개 이상일 때
    // 하나로 합친다.
    // 4개의 파이어볼로 나눈다.
    // 나누어진 파이어볼은 다음과 같다.
    // 질량 = 합쳐진 파이어볼 질량의 합 / 5
    // 속력 = 합쳐진 파이어볼 속력의 합 / 합쳐진 파이어볼 개수
    // 방향 = 4가지 방향 - 모두 홀수 또는 짝수면 0,2,4,6 / 그렇지 않으면 1,3,5,7
    // 질량이 0이면 소멸
    static void magic(int x, int y) {
        // 짝수
        boolean isEven = true;
        // 홀수
        boolean isOdd = true;
        int size = map[x][y].size();

        if (size >= 2) {
            int m = 0;
            int s = 0;
            // 합치기
            for (FireBall ball : map[x][y]) {
                m += ball.m;
                s += ball.s;
                if ( ball.d % 2 == 0) {
                    isOdd = false;
                } else {
                    isEven = false;
                }
            }

            // 방향
            int[] dirs = { 0, 2, 4, 6 };
            // 모두 짝수 또는 홀수가 아닌 경우
            if ( !isOdd && !isEven ) {
                for ( int k = 0; k < 4; k++ ) {
                    dirs[k]++;
                }
            }

            // 4개의 파이어볼로 나누기
            int nm = m / 5;
            int ns = s / size;

            map[x][y].clear();
            if (nm <= 0) return;
            for (int d: dirs) {
                map[x][y].add(new FireBall(x,y,nm,ns,d));
            }
        }
    }
}

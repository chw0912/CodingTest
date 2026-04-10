import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int R, C, M; // R : 행, C : 열, M : 상어의 수
    static int r,c,s,d,z; // (r, c) : 상어의 위치 , s : 속력, d : 이동방향(1-위, 2-아래, 3-오른쪽, 4-왼쪽), z : 크기
    static Shark[] sharks;
    static boolean[] caught; // 잡혔는지 확인(visited)
    static Shark[][] fishingRoom;
    static ArrayDeque<Shark> dq = new ArrayDeque<>();
    static int ans;

    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    // 상어 잡는 규칙
    // 1. 낚시왕이 오른쪽으로 한칸 이동한다 (열 이동)
    // 2. 낚시왕이 있는 열에서 가장 가까운 상어를 잡는다.
    // 3. 상어가 이동한다.
    // 4. 상어 이동 중 격자판 경계를 넘는 경우 방향을 반대로 전환
    // 5. 상어 이동을 마친 후, 칸에 상어가 두 마리 이상 있을 수 있다. 크기가 가장 큰 상어가 나머지 상어를 잡는다.
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fishingRoom = new Shark[R+1][C+1];
        sharks = new Shark[M];
        caught = new boolean[M];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            // 속력을 제자리로 돌아오는 사이클로 나눈 나머지로 줄이기
            if(d == 1 || d == 2) {
                s %= (R-1) * 2;
            } else if(d == 3 || d == 4) {
                s %= (C-1) * 2;
            }

            fishingRoom[r][c] = new Shark(r,c,s,d,z);
        }
    }

    static void solve() {
        // 1. 낚시왕이 1번 열부터 C번 열까지 한 칸씩 이동
        for(int col = 1; col <= C; col++) {
            // 2. 해당 열에서 가장 가까운 상어 잡기
            fishing(col);
            // 3. 살아남은 상어 이동
            move();
        }
    }

    // 상어가 움직이는 함수
    static void move() {
        // 이동 결과를 임시로 저장할 배열
        Shark[][] nextRoom = new Shark[R+1][C+1];
        
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(fishingRoom[i][j] != null) {
                    Shark shark = fishingRoom[i][j];
                    int nextX = shark.r;
                    int nextY = shark.c;
                    int nextD = shark.d;
                    int speed = shark.s;

                    // 속력만큼 한칸씩 이동
                    for(int step = 0; step < speed; step++) {
                        int nx = nextX + dx[nextD];
                        int ny = nextY + dy[nextD];

                        // 격자판 경계를 넘는 경우 방향 전환
                        if(nx < 1 || nx > R || ny < 1 || ny > C) {
                            if (nextD == 1) nextD = 2;
                            else if(nextD == 2) nextD = 1;
                            else if(nextD == 3) nextD = 4;
                            else if(nextD == 4) nextD = 3;

                            // 바뀐 방향으로 다시 이동
                            nx = nextX + dx[nextD];
                            ny = nextY + dy[nextD];
                        }
                        nextX = nx;
                        nextY = ny;
                    }

                    // 상어 정보 업데이트
                    shark.r = nextX;
                    shark.c = nextY;
                    shark.d = nextD;

                    // 같은 칸에 상어가 두마리 이상일 경우
                    if(nextRoom[nextX][nextY] != null) {
                        // 이미 배치된 상어보다 내가 더 크다면 자리를 차지
                        if(nextRoom[nextX][nextY].z < shark.z) {
                            nextRoom[nextX][nextY] = shark;
                        }
                    } else {
                        // 빈 자리일 경우
                        nextRoom[nextX][nextY] = shark;
                    }
                }
            }
        }
        // 이동 완료 후 기존 지도를 새로운 지도로 업데이트
        fishingRoom = nextRoom;
    }

    // 낚시왕이 상어를 잡는 함수
    static void fishing(int col) {
        for (int row = 1; row <= R; row++) {
            // 땅과 가장 가까운 상어를 발견하면
            if (fishingRoom[row][col] != null) {
                // 크기를 정답에 더하기
                ans += fishingRoom[row][col].z;
                // 상어를 지도에서 제거
                fishingRoom[row][col] = null;
                break;
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


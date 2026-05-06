// L12. 고대 문명 유적 탐사

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;

    static final int _90 = 1, _180 = 2, _270 = 3;
    static int K, M;
    static int[][] ruins; // 유적지
    static int[] relics; // 유물 조각
    static int relicsIdx; // 유물 조각 배열의 인덱스
    static StringBuilder sb = new StringBuilder();

    // 이동 전 좌표
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    // 90도 회전 이동 좌표
    static int[] _90_nx = {0, 1, 2, -1, 1, -2, -1, 0};
    static int[] _90_ny = {2, 1, 0, 1, -1, 0, -1, -2};

    // 180도 회전 이동 좌표
    static int[] _180_nx = {2, 2, 2, 0, 0, -2, -2, -2};
    static int[] _180_ny = {2, 0, -2, 2, -2, 2, 0, -2};

    // 270도 회전 이동 좌표
    static int[] _270_nx = {2, 1, 0, 1, -1, 0, -1, -2};
    static int[] _270_ny = {0, -1, -2, 1, -1, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ruins = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ruins[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        relics = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            relics[m] = Integer.parseInt(st.nextToken());
        }


    }

    static void solve() {
        while (K-- > 0) {
            simulate();
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }

    // 90도 회전
    static void rotate(int x, int y, int[][] board, int angle) {

        for (int i = 0; i < 8; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            int nx = 0, ny = 0;

            switch (angle) {
                case _90 :
                    nx = _90_nx[i];
                    ny = _90_ny[i];
                    break;

                case _180 :
                    nx = _180_nx[i];
                    ny = _180_ny[i];
                    break;

                case _270 :
                    nx = _270_nx[i];
                    ny = _270_ny[i];
                    
            }


            int nxtX = curX + nx;
            int nxtY = curY + ny;

            board[nxtX][nxtY] = ruins[curX][curY];

        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = ruins[i][j];
                }
            }
        }

    }

    static void simulate() {

        // 90, 180, 270도 회전 보드판
        int[][] board;

        // 90, 180, 270도 방문 배열
        boolean[][] visited;

        ArrayList<Relic> allRelics = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                board = new int[5][5];
                int temp = 0;
                Relic firstRelics = null;

                // angle은 타입
                // 1 : 90도, 2 : 180도, 3 : 270도
                for (int angle = 1; angle <= 3; angle++) {
                    visited = new boolean[5][5];
                    // 회전
                    rotate(i, j, board, angle);
                    // 유물로 만들 수 있는 조각들
                    Relic relics = findRelics(board, visited, angle, i, j);


                    if (relics.size > temp) {
                        temp = relics.size;
                        firstRelics = relics;
                    }
                }
                if(firstRelics != null) {
                    allRelics.add(firstRelics);
                }
            }
        }
        if (allRelics.isEmpty()) {
            return;
        }
        Relic target = new Relic(6,6,4);

        for (Relic relic : allRelics) {
            if (relic.size > target.size) {
                target = relic;
            } else if (relic.size == target.size) {
                if (relic.type < target.type) {
                    target = relic;
                } else if (relic.type == target.type) {
                    if (relic.y < target.y) {
                        target = relic;
                    } else if (relic.y == target.y) {
                        if (relic.x < target.x) {
                            target = relic;
                        }
                    }
                }
            }
        }

        // 유물 채우기
        board = new int[5][5];

        rotate(target.x, target.y, board, target.type);

        int result = 0;
        while(target.size != 0) {
            visited = new boolean[5][5];
            result += target.size;

            fillRelic(target, board);

            target = findRelics(board, visited, target.type, target.x, target.y);
        }
        if (result != 0) {
            sb.append(result).append(" ");
        }
        ruins = board;

    }

    // 유물 발굴 후 유물 조각 채우기
    static void fillRelic(Relic relic, int[][] board) {
        boolean[][] visited = new boolean[5][5];

        for (int[] d : relic.dirs) {
            int x = d[0];
            int y = d[1];

            visited[x][y] = true;
        }

        for (int y = 0; y < 5 ; y++) {
            for (int x = 4; x >= 0 ; x--) {
                if (visited[x][y]) {
                    board[x][y] = relics[relicsIdx++];
                    if (relicsIdx >= M) {
                        relicsIdx = 0;
                    }
                }
            }
        }
    }

    static class Relic{
        int x, y, type, size = 0;
        ArrayList<int[]> dirs = new ArrayList<>();

        public Relic(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // 유물 조각 찾기
    static Relic findRelics(int[][] board, boolean[][] visited, int type, int x, int y) {
        Relic result = new Relic(x, y, type);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) continue;

                Relic relic = bfs(i,j,board[i][j], type, board, visited);

                if (relic.size >= 3) {
                    result.size += relic.size;
                    result.dirs.addAll(relic.dirs);
                }
            }
        }

        return result;
    }


    static Relic bfs(int x, int y, int target, int type, int[][] board, boolean[][] visited) {
        Relic relic = new Relic(x, y, type);

        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        relic.dirs.add(new int[] {x, y});
        relic.size++;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != target) continue;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
                relic.dirs.add(new int[] {nx, ny});
                relic.size++;
            }
        }

        return relic;
    }

}



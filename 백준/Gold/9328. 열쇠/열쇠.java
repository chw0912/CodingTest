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
    static int T, H, W;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static ArrayList<int[]> lock = new ArrayList<>();
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;


    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {

        // 테스트 케이스 입력
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            // 높이, 너비 초기화
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 문서의 최대개수 출력 초기화
            ans = 0;

            // 빌딩 입력
            map = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            // 소유한 열쇠 입력
            // 알파벳 개수만큼 길이 입력
            // 아스키 코드로 알파벳 열쇠 가능여부 확인(ex. A -> 0번째 인덱스)
            keys = new boolean[26];

            String key = br.readLine();

            if (!key.equals("0")) {
                for (int i = 0; i < key.length(); i++) {
                    keys[key.charAt(i) - 'a'] = true;
                }
            }
            findEntrance();
            bfs();

            // 다음 테스트케이스를 위해 deque 초기화
            dq.clear();
            lock.clear();
            output();
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
    // 입구 찾는 로직
    static void findEntrance() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 현재 위치가 가장자라일 경우
                if ( i == 0 || j == 0 || i == H - 1 || j == W - 1) {
                    // 빈 공간일 경우
                    if (map[i][j] == '.') {
                        dq.offer(new int[] {i, j});
                        visited[i][j] = true;
                    } else if(Character.isUpperCase(map[i][j])) {
                        // 열쇠가 필요한 경우
                        // 해당 열쇠를 소유했는지 확인 후 dq에 offer
                        if (keys[map[i][j] - 'A']) {
                            dq.offer(new int[] {i, j});
                            visited[i][j] = true;
                        } else {
                            lock.add(new int[] {i, j});
                        }
                    } else if (Character.isLowerCase(map[i][j])) {
                        // 만약 열쇠를 소유할 수 있다면
                        dq.offer(new int[] {i, j});
                        keys[map[i][j] - 'a'] = true;
                        visited[i][j] = true;
                    } else if (map[i][j] == '$') {
                        dq.offer(new int[] {i, j});
                        visited[i][j] = true;
                        ans++;
                    }
                }
            }
        }
    }

    static void bfs() {

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < H && 0 <= ny && ny < W && !visited[nx][ny] && map[nx][ny] != '*') {
                    if (map[nx][ny] == '.') {
                        dq.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    } else if(Character.isUpperCase(map[nx][ny])) {
                        if (keys[map[nx][ny] - 'A']) {
                            dq.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        } else {
                            lock.add(new int[] {nx, ny});
                        }
                    } else if (Character.isLowerCase(map[nx][ny])) {
                        keys[map[nx][ny] - 'a'] = true;
                        dq.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        checkIn(map[nx][ny]);
                    } else if(map[nx][ny] == '$') {
                        dq.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        ans++;
                    }
                }
            }
        }
    }

    static void checkIn(char c) {
        for (int[] cur : lock) {
            int x = cur[0];
            int y = cur[1];
            if (map[x][y] == Character.toUpperCase(c)) {
                dq.offer(new int[] {x, y});
            }
        }
    }
}

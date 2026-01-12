// G5. 점프게임

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, k;
    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[2][N];
        visited = new boolean[2][N];

        for (int i = 0; i < 2; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
    }

    static void solve() {
        bfs();
    }

    static void output() throws IOException {
//        for (int i = 0; i < 2; i++) {
//            bw.write(Arrays.toString(map[i]) + "\n");
//        }
        bw.write(String.valueOf(ans));
        bw.flush();

    }

    static void bfs() {
        dq.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int line = cur[0];
            int idx = cur[1];
            int time = cur[2];
            
            int[] nextLines = {line, line, (line+1) % 2};
            int[] nextIndexes = {idx+1, idx -1, idx+k};
            
            for (int i = 0; i < 3; i++) {
                int nextLine = nextLines[i];
                int nextIdx = nextIndexes[i];
                int nextTime = time + 1;
                
                // 1. N 이상으로 넘어가면 성공 
                if (nextIdx >= N) {
                    ans = 1;
                    return;
                }
                
                // 2. 이동 불가능 조건 체크
                if (nextIdx < 0) continue;
                if (nextIdx < nextTime) continue;
                if (map[nextLine][nextIdx] == 0) continue;
                if (visited[nextLine][nextIdx]) continue;
                
                // 3. 이동 가능한 좌표 큐에 삽입
                visited[nextLine][nextIdx] = true;
                dq.offer(new int[] {nextLine, nextIdx, nextTime});
            }
        }
    }

}

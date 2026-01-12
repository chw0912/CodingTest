// G5. 점프게임

import java.io.*;
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
        if(dfs(0,0,0)) ans = 1;
    }

    static void output() throws IOException {
//        for (int i = 0; i < 2; i++) {
//            bw.write(Arrays.toString(map[i]) + "\n");
//        }
        bw.write(String.valueOf(ans));
        bw.flush();

    }

    static boolean dfs(int line, int idx, int time) {
        boolean isPossible = false;

        // 게임 클리어
        if ( idx >= N ) {
            isPossible = true;
            return isPossible;
        }
        
        // 방문 처리
        if ( idx >= 0 && visited[line][idx]) {
            return isPossible;
        }
        
        // 범위를 벗어나는 경우
        if ( idx < 0 ) {
            return isPossible;
        }
        // 해당 칸은 위험한 칸일 경우
        if (map[line][idx] == 0) {
            return isPossible;
        }

        // 1초에 한칸씩 사라지는 기능
        if ( idx < time ) {
            return isPossible;
        }

        // 방문 처리
        visited[line][idx] = true;

        // 뒤로 한칸 이동할 경우
        if (dfs(line, idx-1, time+1)) {
            return true;
        }
        // 라인을 변경할 경우
        if (dfs((line+1) % 2, idx+k, time+1)) {
            return true;
        }
        // 앞으로 한칸 이동할 경우
        if (dfs(line, idx+1, time+1)) {
            return true;
        }

        return false;
    }
}

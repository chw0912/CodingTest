import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static char[][] map;
    static int max = -Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
    }

    static void solve() {
        dfs(0,0, 0, '+');
    }

    static void output() throws IOException {
        bw.write(max + " " + min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int pre, char oper) {

        if (Character.isDigit(map[x][y])) {
            int cur = map[x][y] - '0';
            if (oper == '+') {
                pre += cur;
            } else if (oper == '-') {
                pre -= cur;
            } else {
                pre *= cur;
            }
        } else {
            oper = map[x][y];
        }

        if (x == N - 1 && y == N - 1) {
            max = Math.max(max, pre);
            min = Math.min(min, pre);
            return;
        }

        if ( x < N - 1 ) {
            dfs(x+1, y, pre, oper);
        }
        if ( y < N - 1 ) {
            dfs(x, y+1, pre, oper);
        }


    }


}

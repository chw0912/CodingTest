import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static String[][] map;
    static boolean[][] visited;
    static int max = -Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static ArrayList<String> operations = new ArrayList<>(Arrays.asList("+", "-", "*"));
    static int[][] dp;
    static int idx = -1; // operations 인덱스

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
            }
        }
    }

    static void solve() {
        dfs(0,0, 0, "+");
    }

    static void output() throws IOException {
        bw.write(max + " " + min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int pre, String oper) {
        if (x == N - 1 && y == N - 1) {
            max = Math.max(max, operating(oper, pre, Integer.parseInt(map[x][y])));
            min = Math.min(min, operating(oper, pre, Integer.parseInt(map[x][y])));
            return;
        }

        int temp;

        if (isOperation(map[x][y])) {
            if(map[x][y].equals("+")) {
                oper = "+";
            } else if(map[x][y].equals("-")) {
                oper = "-";
            } else {
                oper = "*";
            }
            temp = pre;
        } else {
            temp = operating(oper, pre, Integer.parseInt(map[x][y]));
        }

        if ( x < N - 1 ) {
            dfs(x+1, y, temp, oper);
        }
        if ( y < N - 1 ) {
            dfs(x, y+1, temp, oper);
        }


    }

    static boolean isOperation(String value) {
        try {
            Integer.parseInt(value);
            return false;
        } catch ( NumberFormatException e ) {
            return true;
        }
    }

    static int operating(String operation, int ans, int num) {
        if (operation.equals("+")) {
            return ans + num;
        } else if (operation.equals("-")) {
            return ans - num;
        } else {
            // "*"
            return ans * num;
        }
    }

}

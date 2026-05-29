import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static boolean solved = false;
    static int[][] sudoku = new int[9][9];
    static ArrayList<Node> blanks = new ArrayList<>();

    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                sudoku[i][j] = num;

                if (num == 0) {
                    blanks.add(new Node(i, j));
                }
            }
        }
    }

    static void solve() {
        dfs(0);
    }

    public static void dfs(int idx) {
        if (solved) return;

        if (idx == blanks.size()) {
            solved = true;
            return;
        }

        Node cur = blanks.get(idx);
        int x = cur.x;
        int y = cur.y;

        for (int i = 1; i <= 9; i++) {
            if (isAvailable(x, y, i)) {
                sudoku[x][y] = i;
                dfs(idx + 1);
                if(solved) return;
                sudoku[x][y] = 0;
            }
        }
    }

    public static boolean isAvailable(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val) return false;
            if (sudoku[i][y] == val) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[startX + i][startY + j] == val) return false;
            }
        }

        return true;
    }

    static void output() throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(sudoku[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}


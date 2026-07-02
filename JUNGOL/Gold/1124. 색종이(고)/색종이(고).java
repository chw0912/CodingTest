import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, max_count, ans; // N : 색종이의 수, max_count : 색종이끼리 겹치는 최대 값, ans : 잘라낼 수 있는 검은색 직사각형의 최대 넓이
    static int[][] paper; // 최대 넓이 - 100 X 100,
    static boolean[][] colVisited, rowVisited; // 색종이끼리 겹치는 최대값 칸 방문처리
    static Queue<Node> queue =  new LinkedList<>();

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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
        N = Integer.parseInt(br.readLine());

        paper = new int[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int nx = x; nx < x+10; nx++) {
                for (int ny = y; ny < y+10; ny++) {
                    paper[nx][ny]++;
                }
            }
        }
    }

    static void solve() {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] > 0) {

                    int minHeight = 101;

                    for (int w = 0; j+w < 101; w++) {
                        if (paper[i][j+w] == 0) break;

                        int curHeight = getColumn(i, j+w);

                        minHeight = Math.min(minHeight, curHeight);

                        int curSize = (w+1) * minHeight;
                        if (ans < curSize) ans = curSize;
                    }
                }
            }
        }

    }

    // 세로 길이 구하기
    static int getColumn(int x, int y) {
        int col = 0;

        while (x < 101 && paper[x][y] > 0) {
            col++;
            x++;
        }

        return col;
    }


    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}



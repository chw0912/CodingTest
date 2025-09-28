import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        bw.write((int) Math.pow(2, N) - 1 + "\n");
        dfs(N, 1,2,3);
    }

    static void output() throws IOException {

        bw.flush();
        bw.close();
    }

    /**
     *
     * @param N : 원판 개수
     * @param from : 출발지
     * @param mid : 옮기기 위해 이동 해야하는 장소
     * @param to : 목적지
     */
    static void dfs(int N, int from, int mid, int to) throws IOException {

        if (N == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        // 출발지 -> 목적지
        dfs(N-1, from, to, mid);

        // 출발지 -> 목적지 출력
        bw.write(from + " " + to + "\n");

        // 옮겨야 할 장소 -> 목적지
        dfs(N-1, mid, from, to);
    }
}
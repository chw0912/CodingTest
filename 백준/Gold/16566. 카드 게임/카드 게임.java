import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M, K; // N : 카드의 수, M : 뽑은 카드 수, K : 철수가 낼 카드의 수
    static int[] drawCard, cheolsu;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M];
        drawCard = new int[M];
        cheolsu = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            drawCard[m] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            cheolsu[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drawCard);
    }

    static void solve() {
        for (int i = 0; i < K; i++) {
            int target = cheolsu[i];
            int idx = binarySearch(target);

            if (drawCard[idx] == target) {
                idx++;
            }

            while (visited[idx]) {
                idx++;
            }

            visited[idx] = true;
            sb.append(drawCard[idx]).append("\n");
        }
    }

    static int binarySearch(int target) {
        int left = 0, right = M - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (drawCard[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


// [Gold 3] 1318. 못생긴 수

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        numbers = new int[1501];
        N = Integer.parseInt(br.readLine().trim());

        int idx_2 = 1, idx_3 = 1, idx_5 = 1;
        int next_2 = 2, next_3 = 3, next_5 = 5;
        numbers[1] = 1;

        for (int i = 2; i <= 1500; i++) {
            numbers[i] = Math.min(next_2, Math.min(next_3, next_5));
            if (numbers[i] == next_2) {
                idx_2++;
                next_2 = numbers[idx_2] * 2;
            }

            if (numbers[i] == next_3) {
                idx_3++;
                next_3 = numbers[idx_3] * 3;
            }

            if (numbers[i] == next_5) {
                idx_5++;
                next_5 = numbers[idx_5] * 5;
            }
        }

        while (N != 0) {
            sb.append(numbers[N]).append("\n");
            N = Integer.parseInt(br.readLine().trim());
        }
    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(sb.toString());
//        for (int i = 1; i <= 1500; i++) {
//            bw.write(numbers[i] + "\n");
//        }
        bw.flush();
    }
}

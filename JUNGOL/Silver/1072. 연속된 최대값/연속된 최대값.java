// [Silver 5] 1072. 연속된 최대값

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static int left, right, ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int temp = 0;

        while (left <= right && left < N) {
            if (right - left < M && right < N) {
                temp += numbers[right++];
            } else {
                temp -= numbers[left++];
            }

            if (right - left == M) ans = Math.max(ans, temp);
        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}


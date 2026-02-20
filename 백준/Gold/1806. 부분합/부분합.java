import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, S;
    static int[] arr;
    static int left, right, sum;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        while (left <= N && right <= N) {
            if (sum >= S) {
                ans = Math.min(ans, right-left);
                sum -= arr[left++];
            } else {
                sum += arr[right++];
            }
        }


    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans == Integer.MAX_VALUE ? 0 : ans));
        bw.flush();
    }
}

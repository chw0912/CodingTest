import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] A, LIS;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        LIS = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int len = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > LIS[len]) {
                LIS[++len] = A[i];
            } else {
                idx = binarySearch(len, A[i]);
                LIS[idx] = A[i];
            }
        }

        ans = len;
    }

    static int binarySearch(int right, int target) {
        int left = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target > LIS[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


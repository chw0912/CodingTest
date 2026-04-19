import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] A;
    static int[] LIS;
    static int[] dp; // 증가 부분 수열의 크기 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];
        LIS = new int[N+1];

        LIS[0] = -1_000_000_001;

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
                dp[i] = ++len;
                LIS[len] = A[i];
            } else {
                idx = binarySearch(len, A[i]);
                LIS[idx] = A[i];
                dp[i] = idx;
            }
        }
        sb.append(len).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == len) {
               stack.push(A[i]);
               len--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
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
        bw.write(sb.toString());
        bw.flush();
    }
}


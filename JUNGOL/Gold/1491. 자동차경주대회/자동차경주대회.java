// [Gold 4] 1491. 자동차경주대회

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int K, N; // K : 정비 받지 않고 갈 수 있는 최대 거리, N: 정비소의 개수
    static int[] garage, duration; // garage: 정비소 사이의 거리, duration: 각 정비소별 정비 소요시간
    static int[] dp, parent;
    static int cnt;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        garage = new int[N+2];
        parent = new int[N+2];
        duration = new int[N+2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N+1; i++) {
            garage[i] = Integer.parseInt(st.nextToken()) + garage[i-1];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            duration[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
    }

    static void solve() {
        for (int i = 1; i <= N+1; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (garage[i] - garage[j] > K) break;

                if (dp[i] >= dp[j] + duration[j]) {
                    dp[i] = dp[j] + duration[j];
                    parent[i] = j;
                }
            }
        }


        int cur = parent[N+1];
        while (cur != 0) {
            stack.push(cur);
            cur = parent[cur];
            cnt++;
        }
    }

    static void output() throws IOException {
        sb.append(dp[N+1]).append("\n");
        if (cnt == 0) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }

        sb.append(cnt).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}


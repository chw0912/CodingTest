import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // 남자, 여자
    static int[] male;
    static int[] female;
    static int[][] dp;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        male = new int[N+1];
        female = new int[M+1];
        dp = new int[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        for ( int i = 1; i <= N; i++ ) {
            male[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for ( int i = 1; i <= M; i++ ) {
            female[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(male);
        Arrays.sort(female);


    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ( i == j ) {
                    dp[i][j] = Math.abs(male[i]-female[j]) + dp[i-1][j-1];
                } else if ( i > j ) {
                    dp[i][j] = Math.min(Math.abs(male[i]-female[j]) + dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.min(Math.abs(male[i]-female[j]) + dp[i-1][j-1], dp[i][j-1]);
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(dp[N][M]));
        bw.flush();
        bw.close();
    }
}

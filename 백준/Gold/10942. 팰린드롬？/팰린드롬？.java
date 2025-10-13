import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N; // 수열의 크기
    static int[] numbers; // N개의 수 1-based
    static int M; // 질문의 개수
    static int[][] questions;
    static boolean[][] dp; //[현재 위치(S)][마지막 위치(E)] 1-based


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for ( int i = 1; i <= N; i++ ) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        questions = new int[M][2];
        dp = new boolean[N+1][N+1];
        for ( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        palindrome();
    }

    static void output() throws IOException {
        for ( int i = 0; i < M; i++ ) {
            int s = questions[i][0];
            int e = questions[i][1];
            if ( dp[s][e] ) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void palindrome() {
        // 자기자신은 펠린드롬
        for ( int i = 1; i <= N; i++ ) {
            dp[i][i] = true;
        }
        // 자기 자신과 앞글자가 같다면 펠린드롬
        for ( int i = 1; i< N; i++ ) {
            if ( numbers[i] == numbers[i+1] ) {
                dp[i][i+1] = true;
            }
        }
        // i번째 글자와 j번째 글자가 같은 경우
        // i+1번째 글자와 j-1번째 글자가 펠린드롬이면
        // i번째 부터 j번째 글자가 펠린드롬이다.
        for ( int k = 2; k <= N; k++ ) {
            for ( int i = 1; i <= N - k; i++) {
                int j = i + k;
                if ( numbers[i] == numbers[j] && dp[i+1][j-1] ) {
                    dp[i][j] = true;
                }
            }
        }

    }

}

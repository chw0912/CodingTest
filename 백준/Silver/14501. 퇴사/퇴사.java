import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N; // 최대 상담 가능일

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            // 상담 완료 날짜가 N을 넘기지 않는다면
            if (i + T <= N) {
                // 해당 완료 날짜의 데이터와 현재 날짜에서
                dp[i+T] = Math.max(dp[i+T], dp[i] + P);
            }

            // 오늘 일한 금액을 다음날과 비교
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }


}

import java.io.*;
import java.util.StringTokenizer;


// 14501 [S3] 퇴사
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            // 상담 완료 날짜가 N을 넘기지 않는다면
            if (i + T <= N) {
                // 해당 완료 날짜의 데이터와 현재 날짜와 완료된 날의 금액을 더하여 큰값 저장
                dp[i + T] = Math.max(dp[i + T], dp[i] + P);
            }

            // 오늘 일한 금액을 다음날로
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }


}

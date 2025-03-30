import java.io.*;
import java.util.StringTokenizer;

//12865 [G4] 평범한 배낭
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K; // N : 물품의 수 , K : 버틸 수 있는 무게

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[K+1];
        
        // N번 반복하여 무게(W)와 가치(V) 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int j = K; j >= 0; j-- ) {
                if (j - W >= 0) {
                    if (dp[j] < dp[j-W] + V) {
                        dp[j] = dp[j-W] + V;
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[K]));
        bw.flush();

    }

}

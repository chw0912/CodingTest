import java.util.Scanner;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. 이항 계수(nCr) 테이블 미리 만들기 (DP 방식)
        // 52장의 카드 중 r장을 뽑는 모든 경우의 수를 저장
        int[][] nCr = new int[53][53];
        for (int i = 0; i <= 52; i++) {
            nCr[i][0] = 1; // n개 중 0개를 뽑는 경우의 수는 1
            for (int j = 1; j <= i; j++) {
                // nCr = n-1Cr-1 + n-1Cr 성질 이용
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }

        int result = 0;

        // 2. 포함-배제의 원리 적용
        // i는 포카드의 쌍 개수 (포카드는 숫자가 총 13종류이므로 1~13까지 가능)
        // 단, 포카드 i쌍을 뽑으려면 필요한 카드 수(i*4)가 전체 뽑는 카드 수(N)보다 작거나 같아야 함
        for (int i = 1; i <= 13 && i * 4 <= N; i++) {

            // (13종류 중 i종류의 포카드를 고르는 경우) * (나머지 카드 중 남은 장수를 뽑는 경우)
            int cases = (nCr[13][i] * nCr[52 - 4 * i][N - 4 * i]) % MOD;

            if (i % 2 == 1) {
                // 홀수 번째 (1쌍, 3쌍, 5쌍...): 더하기
                result = (result + cases) % MOD;
            } else {
                // 짝수 번째 (2쌍, 4쌍, 6쌍...): 빼기
                // 뺄셈 결과가 음수가 될 수 있으므로 MOD를 더한 후 나머지 연산
                result = (result - cases + MOD) % MOD;
            }
        }

        System.out.println(result);
    }
}
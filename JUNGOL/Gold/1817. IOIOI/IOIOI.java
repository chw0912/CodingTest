import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, ans;
    static char[] S; // String[] 대신 처리가 빠른 char[] 사용

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // split("") 대신 toCharArray()를 사용하면 속도가 훨씬 빠릅니다.
        S = br.readLine().toCharArray();
    }

    static void solve() {
        int patternCount = 0; // 연속된 "IOI" 패턴의 개수를 저장할 변수

        // M-2 까지만 검사합니다. (i, i+1, i+2를 한 번에 확인하기 때문)
        for (int i = 0; i < M - 2; i++) {
            // "IOI" 패턴이 발견되었는지 확인
            if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I') {
                patternCount++; // 연속 패턴 개수 증가

                // 패턴이 N번 연속으로 나왔다면 (우리가 찾는 문자열 발견)
                if (patternCount == N) {
                    ans++; // 정답 증가
                    patternCount--; // 다음 "IOI" 패턴이 현재 패턴의 마지막 'I'와 겹치므로 1만 감소시킴
                }

                i++; // 'O'를 건너뛰고 다음 'I' 위치로 가기 위해 i를 1 증가시킴 (for문의 i++와 합쳐져 총 2 증가)
            } else {
                // 패턴이 끊겼다면 연속 개수를 0으로 초기화
                patternCount = 0;
            }
        }
    }

    static void output() {
        // BufferedWriter 대신 System.out.println 하나만 호출해도 충분히 빠릅니다.
        System.out.println(ans);
    }
}
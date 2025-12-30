import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] guilt; // 유죄 지수
    static int[][] R;
    static int mafia;
    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        guilt = new int[N];
        R = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            guilt[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafia = Integer.parseInt(br.readLine());
    }

    static void solve() {
        dfs(N, 0);
    }

    private static int getHighScoreIndex() {
        int high = -1;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (guilt[i] > high) {
                high = guilt[i];
                index = i;
            }
        }
//        out.println(index);
        return index;

    }

    static void output() throws IOException {
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void dfs(int alive, int ans) {
//        out.println(alive + ", " + ans);
//        for (int i = 0; i < N; i++) {
//            out.print(guilt[i] + " ");
//        }
//        out.println();


        if (alive == 1 || guilt[mafia] == -1) {
            result = Math.max(result, ans);
            return;
        }

        // 낮
        if (alive % 2 == 1) {
            // 유죄 지수가 가장 높은 사람 구하기
            int index = getHighScoreIndex();
            int temp = guilt[index];
//            out.println(alive + " : " + index);
            guilt[index] = -1;
            dfs(alive - 1, ans);
            guilt[index] = temp;
        }
        // 밤
        else {
            // 마피아가 시민을 죽일수 있다.
            // 자기 자신은 제외한 나머지를 한명씩 죽여본다.
            for (int i = 0; i < N; i++) {
                if (mafia == i || guilt[i] == -1) continue;
                int temp = guilt[i];
                guilt[i] = -1;
                // 지수 계산
                for (int j = 0; j < N; j++) {
                    if (guilt[j] == -1) continue;
                    guilt[j] += R[i][j];
                }

                dfs(alive - 1, ans + 1);

                // 되돌리기
                guilt[i] = temp;
                for (int j = 0; j < N; j++) {
                    if (guilt[j] == -1 || j == i) continue;
                    guilt[j] -= R[i][j];
                }
            }
        }

    }
}

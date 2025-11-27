import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int UNKNOWN = 0, FINDING = 1, MATCHED = 2, MISMATCH = -1;
    static int T; // 테스트 케이스
    static int N; // 학생 수
    static int[] students;  // 선택된 학생들의 번호, 1-based
    static int[] state;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        ans = new int[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            students = new int[N+1];
            state = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if ( state[i] == 0 ) {
                    if ( state[i] == UNKNOWN ) {
                        dfs(i);
                    }
                }
            }

            for ( int i = 1; i <= N; i++) {
                if (state[i] == MISMATCH ) {
                    ans[t]++;
                }
            }
        }

    }

//    static void solve() {
//        dfs(1);
//    }

    static void output() throws IOException {
        for (int t = 0; t < T; t++) {
            bw.write(ans[t] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int student) {

        if (state[student] == FINDING) {
            cycle(student, MATCHED);
            return;
        }

        if (state[student] == MATCHED || state[student] == MISMATCH ) {
            return;
        }

        state[student] = FINDING;
        dfs(students[student]);
        if (state[student] != MATCHED) {
            state[student] = MISMATCH;
        }
    }

    static void cycle(int student, int status) {
        if (state[student] == status) return;
        state[student] = status;
        cycle(students[student], status);
    }
}

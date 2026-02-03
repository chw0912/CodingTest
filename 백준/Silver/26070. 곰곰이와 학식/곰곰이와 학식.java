import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int[] gomgom;    // 곰곰이
    static int[] tickets;   // 식권
    static int[] remainder;  // 남는 식권
    static int[] couldNotEatGomgom; // 먹지못한 곰곰이
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        gomgom = new int[3];
        tickets = new int[3];
        remainder = new int[3];
        couldNotEatGomgom = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gomgom[i] = Integer.parseInt(st.nextToken());
            ans += gomgom[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            if (gomgom[i] < tickets[i]) {
                remainder[i] = tickets[i] - gomgom[i];
            } else {
                couldNotEatGomgom[i] = gomgom[i] - tickets[i];
            }
        }


    }

    static void solve() {

        for (int i = 0; i < 3; i++) {
            if (remainder[i] > 0) {
                int idx = (i + 1) % 3;
                while (remainder[i] >= 3 && couldNotEatGomgom[idx] > 0) {
                    remainder[i] -= 3;
                    couldNotEatGomgom[idx] -= 1;
                }
                idx = (idx+1) % 3;
                while (remainder[i] > 9 && couldNotEatGomgom[idx] > 0) {
                    remainder[i] -= 9;
                    couldNotEatGomgom[idx] -= 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            ans -= couldNotEatGomgom[i];
        }

    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

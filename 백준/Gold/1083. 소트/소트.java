import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        S = Integer.parseInt(br.readLine());
    }

    static void solve() {

        for (int i = 0; i < N && S > 0; i++) {
            int idx = i;

            // 
            for (int j = i + 1; j < N && j <= i+S; j++) {
                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }

            // swap
            for (int j = idx; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

            S -= (idx-i);
        }

    }

    static void output() throws IOException {
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }



}

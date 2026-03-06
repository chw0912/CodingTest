import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int l, r;


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
    }

    static void solve() {
        int left = 0;
        int right = N-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                l = left;
                r = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
    }

    static void output() throws IOException {
        bw.write(arr[l] + " " + arr[r] + "\n");
        bw.flush();
    }
}

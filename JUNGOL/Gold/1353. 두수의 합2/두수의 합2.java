import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static int ans;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    static void solve() {
        int left = 0, right = N-1;

        while (left < right) {
            if (numbers[left] + numbers[right] < M) {
                left++;

            } else if (numbers[left] + numbers[right] > M) {
                right--;
            } else {
                left++;
                right--;
                ans++;
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}




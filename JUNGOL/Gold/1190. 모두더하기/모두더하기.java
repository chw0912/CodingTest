// [Gold 4] 1190. 모두더하기

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static long ans;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Integer.parseInt(st.nextToken());
            pq.offer(num);
        }
    }

    static void solve() {
        while (!pq.isEmpty()) {

            if (pq.size() == 1) {
                break;
            }
            long num1 = pq.poll();
            long num2 = pq.poll();

            long sum = num1 + num2;
            ans += sum;
            pq.offer(sum);

        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, C, M, ans;
    static Delivery[] info;
    static int[] capacity;

    public static class Delivery implements Comparable<Delivery> {
        int start, end, box;

        public Delivery(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }

        @Override
        public int compareTo(Delivery o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        info = new Delivery[M];
        capacity = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());

            info[i] = new Delivery(start, end, box);

        }

        Arrays.sort(info);
        Arrays.fill(capacity, C);
    }

    static void solve() {
        for (int i = 0; i < M; i++) {
            Delivery curr = info[i];

            int min = C;
            for (int j = curr.start; j < curr.end; j++) {
                min = Math.min(min, capacity[j]);
            }

            int carry = Math.min(curr.box, min);

            if (carry > 0) {
                for (int j = curr.start; j < curr.end; j++) {
                    capacity[j] -= carry;
                }
                ans += carry;
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}



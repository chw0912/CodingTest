import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K;
    static Jewelry[] jewelries;
    static int[] bags;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static long ans;

    public static class Jewelry {
        int m, v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
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
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(M, V);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.m == o2.m) return o1.v - o2.v;
                return o1.m - o2.m;
            }
        });

        for(int i = 0; i < K; i++) {
           bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
    }

    static void solve() {
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelries[j].m <= bags[i]) {
                pq.offer(jewelries[j++].v);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }

        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

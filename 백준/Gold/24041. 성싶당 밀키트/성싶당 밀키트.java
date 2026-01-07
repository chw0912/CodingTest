import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, G, K;
    static int S, L, O; // 부패 속도, 유통기한, 중요 여부
    static Ingredient[] ingredients;
    static long ans;

    public static class Ingredient {
        int s, l, o;

        public Ingredient(int s, int l, int o) {
            this.s = s;
            this.l = l;
            this.o = o;
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
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ingredients = new Ingredient[N];

        for ( int n = 0; n < N; n++ ) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());

            ingredients[n] = new Ingredient(S, L, O);
        }

    }

    static void solve() {
        long left = 1, right = Integer.MAX_VALUE - 1;

        while ( left <= right ) {
            long mid = (left + right) / 2;

            long totalGerm = countTotalGerm(mid);

            if ( totalGerm <= G ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        ans = right;
    }

    static long countTotalGerm(long day) {
        long totalGerm = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (Ingredient ingredient : ingredients) {
            long germ = ingredient.s * Math.max(1, day - ingredient.l);
            totalGerm += germ;
            if ( ingredient.o == 1 ) {
                pq.offer(germ);
            }
        }

        int k = K;
        
        while (!pq.isEmpty() && k-->0) {
            totalGerm -= pq.poll();
        }

        return totalGerm;
    }

    static void output() throws IOException {
//        for ( int n = 0; n < N; n++ ) {
//            bw.write("S = " + ingredients[n].s + " L = " + ingredients[n].l + " O = "+ ingredients[n].o + "\n");
//        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

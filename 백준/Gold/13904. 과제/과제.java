import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Integer>> homework = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 1000; i++) {
            homework.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            homework.get(end).add(score);
        }
    }

    static void solve() {
        for (int day = 1000; day >= 1; day--) {
            for ( int score : homework.get(day) ) {
                pq.offer(score);
            }

            if ( !pq.isEmpty() ) {
                ans += pq.poll();
            }
        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int MAX_SIZE = 200_000_000 + 1;
    static int N, K;
    static HashSet<Integer> visited;
    static Queue<Point> queue = new LinkedList<>();
    static long ans;

    static class Point {
        int pos, dist;

        public Point(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
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

        visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int p = Integer.parseInt(st.nextToken());
            visited.add(p);
            queue.offer(new Point(p, 0));
        }
    }

    static void solve() {
        int count = 0;
        while(!queue.isEmpty()) {
            Point curr = queue.poll();

            int[] nextPos = {curr.pos - 1, curr.pos + 1};

            for (int next : nextPos) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    count++;
                    ans += (curr.dist + 1);
                    
                    if (count == K) return;

                    queue.offer(new Point(next, curr.dist+1));
                }

               

            }
        }
    }



    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();

    }
}


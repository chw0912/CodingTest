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
    static int N;
    static int[][] gas;
    static int L, P;
    static int[][] road;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()) ;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        gas = new int[N][2];

        for ( int n = 0; n < N; n++ ) {
            st = new StringTokenizer(br.readLine());
            gas[n][0] = Integer.parseInt(st.nextToken());
            gas[n][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        road = new int[L+1][2];
        Arrays.sort(gas, (o1, o2) -> o1[0] - o2[0]);

        for ( int n = 0; n < N; n++ ) {
            // 주유소에서 넣을 수 있는 주유량
            road[gas[n][0]][1] = gas[n][1];
        }
        road[L][0] = -1;

    }

    static void solve() {
       
        for ( int l = 0; l <= L; l++ ) {
            if ( P < 0 ) {
                if ( pq.isEmpty() ) break;
                P += pq.poll();
                ans++;
            }
            if ( road[l][1] != 0 ) {
                pq.offer(road[l][1]);
            }
            road[l][0] = P--;
        }

    }

    static void output() throws IOException {
        if ( road[L][0] < 0 ) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(ans));
        }
        bw.flush();
    }
}


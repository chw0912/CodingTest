import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static int amount;
    static int[] knowledge;
    static ArrayList<ArrayList<Integer>> party = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    static int ans = 0;


    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        for ( int n = 0; n <= N; n++ ) {
            adj.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        amount = Integer.parseInt(st.nextToken());
        if ( amount == 0 ) {
            ans = M;
            return;
        }
        knowledge = new int[amount];
        for ( int a = 0; a < amount; a++ ) {
            int person = Integer.parseInt(st.nextToken());
            knowledge[a] = person;
            visited[person] = true;
        }

        for ( int i = 0; i < M; i++ ) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for ( int j = 0; j < a; j++ ) {
                party.get(i).add(Integer.parseInt(st.nextToken()));
            }
            for ( int k = 0; k < a; k++ ) {
                for ( int h = 0; h < a; h++ ) {
                    if ( k == h ) continue;
                    if ( adj.get(party.get(i).get(k)).contains(party.get(i).get(h))) continue;
                    adj.get(party.get(i).get(k)).add(party.get(i).get(h));
                }
            }
        }
        solve();
    }

    static void solve() {
        for (int j : knowledge) {
            bfs(j);
        }

        for ( int m = 0; m < M; m++ ) {
            ans++;
            for ( int cur : party.get(m) ) {
                if ( visited[cur] ) ans--;
                break;
            }
        }

    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void bfs(int x) {
        queue.offer(x);

        while( !queue.isEmpty() ) {
            int cur = queue.poll();
            visited[cur] = true;

            for ( int next : adj.get(cur) ) {
                if (visited[next]) continue;
                queue.offer(next);
            }
        }
    }
}


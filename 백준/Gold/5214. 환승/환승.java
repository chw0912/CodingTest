import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K, M; // 역의 수, 서로 연결하는 역의 개수, 하이퍼튜브 개수
    static ArrayList<ArrayList<Integer>> tubeStation = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int len = N+M+1;
        visited = new int[len];
        for ( int i = 0; i <= len; i++ ) {
            tubeStation.add(new ArrayList<>());
        }

        for ( int m = 1; m <= M; m++ ) {
            st = new StringTokenizer(br.readLine());
            int tube = N+m;
            for ( int k = 0; k < K; k++ ) {
                int station = Integer.parseInt(st.nextToken());
                tubeStation.get(station).add(tube);
                tubeStation.get(tube).add(station);
            }
        }
    }

    static void solve() {
        bfs();
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void bfs() {
        queue.offer(1);
        visited[1] = 1;

        while( !queue.isEmpty() ) {
            int station = queue.poll();
            if ( station == N ) {
                ans = visited[N];
                break;
            }

            for ( int nextStation : tubeStation.get(station) ) {
                if ( visited[nextStation] == 0 ) {
                    if ( station > N ) {
                        visited[nextStation] = visited[station];
                    } else {
                        visited[nextStation] = visited[station] + 1;
                    }
                    queue.offer(nextStation);
                }
            }
        }
    }


}


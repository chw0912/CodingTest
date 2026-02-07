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
    static final int LIMIT_PLAYER = 11;
    static int N, K;
    static ArrayList<PriorityQueue<Integer>> team = new ArrayList<>();
    static int ans;

    static class Player {
        int value;

        Player(int value) {
            this.value = value;
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
        for (int i = 0; i <= LIMIT_PLAYER; i++) {
            team.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            int playerValue = Integer.parseInt(st.nextToken());
            team.get(teamNum).add(playerValue);
        }

    }

    static void solve() {
        while (K-- > 0) {
            for (int i = 1; i <= LIMIT_PLAYER; i++) {
                if (!team.get(i).isEmpty()) {
                    int player = team.get(i).poll() - 1;
                    team.get(i).offer(player);
                }
            }
        }

        for (int i = 1; i <= LIMIT_PLAYER; i++) {
            if (!team.get(i).isEmpty()) {
                ans += team.get(i).poll();
            }
        }

    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

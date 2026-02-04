import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int C, R;
    static int N;
    static Store[] block;
    static Store player;
    static int ans;


    public static class Store {
        int x, y;

        public Store(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        block = new Store[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            block[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        player = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            if ( block[i].x == player.x ) {
                ans += Math.abs(block[i].y - player.y);
            } else {
                switch (player.x) {
                    case 1: {
                        if (block[i].x == 2) {
                            ans += Math.min(player.y + block[i].y + R, C-player.y + C - block[i].y + R);
                        } else if ( block[i].x == 3) {
                            ans += player.y + block[i].y;
                        } else if ( block[i].x == 4) {
                            ans += C - player.y + block[i].y;
                        }
                    }
                    continue;
                    case 2: {
                        if (block[i].x == 1) {
                            ans += Math.min(player.y + block[i].y + R, C-player.y + C - block[i].y + R);
                        } else if ( block[i].x == 3 ) {
                            ans += player.y + R - block[i].y;
                        } else if ( block[i].x == 4 ) {
                            ans += C - player.y + R - block[i].y;
                        }
                    }
                    continue;
                    case 3: {
                        if (block[i].x == 1) {
                            ans += player.y + block[i].y;
                        } else if ( block[i].x == 2 ) {
                            ans += R - player.y + block[i].y;
                        } else if ( block[i].x == 4 ) {
                            ans += Math.min(player.y + block[i].y + C, R-player.y + R - block[i].y + C);
                        }
                    }
                    continue;
                    case 4: {
                        if (block[i].x == 1) {
                            ans += player.y + C - block[i].y;
                        } else if ( block[i].x == 2 ) {
                            ans += R - player.y + R - block[i].y;
                        } else if ( block[i].x == 3 ) {
                            ans += Math.min(player.y + block[i].y + C, R-player.y + R - block[i].y + C);
                        }
                    }
                }
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

}

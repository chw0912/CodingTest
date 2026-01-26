import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int p, m;
    static int l;
    static String n;
    static ArrayList<ArrayList<Player>> room = new ArrayList<>();

    public static class Player implements Comparable<Player> {
        int l;
        String n;

        public Player(int l, String n) {
            this.l = l;
            this.n = n;
        }

        @Override
        public int compareTo(Player o) {
            return this.n.compareTo(o.n);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            room.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();

            for (int j = 0; j <= i; j++) {
                if (room.get(j).isEmpty()) {
                    room.get(j).add(new Player(l, n));
                    break;
                } else {
                    if (room.get(j).size() < m) {
                        if (room.get(j).get(0).l + 10 >= l && room.get(j).get(0).l - 10 <= l) {
                            room.get(j).add(new Player(l, n));
                            break;
                        }
                    }
                }
            }
        }

        for ( int i = 0; i < p; i++) {
            if ( !room.get(i).isEmpty() ) {
                Collections.sort(room.get(i));
            }
        }

    }

    static void solve() {

    }

    static void output() throws IOException {
        for (int i = 0; i < p; i++) {
            if ( !room.get(i).isEmpty() ) {
                if ( room.get(i).size() == m ) {
                    bw.write("Started!\n" );
                } else {
                    bw.write("Waiting!\n");
                }
                for ( int j = 0; j < room.get(i).size(); j++) {
                    bw.write(room.get(i).get(j).l + " " + room.get(i).get(j).n + "\n");
                }
            }
        }
        bw.flush();
    }
}


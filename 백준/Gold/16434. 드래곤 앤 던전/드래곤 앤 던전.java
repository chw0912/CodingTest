import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, H;
    static int t, a, h;
    static Warrior warrior;
    static Dungeon[] dungeon;
    static long maxHP;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        warrior = new Warrior(H);
        dungeon = new Dungeon[N];

        for ( int n = 0; n < N; n++ ) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            dungeon[n] = new Dungeon(t, a, h);
        }

    }

    static void solve() {

        long curHP = 0;

        for ( int n = 0; n < N; n++ ) {
            Dungeon monster = dungeon[n];

            if ( monster.type == 1 ) {
                long hits = monster.hp / warrior.atk;
                if ( monster.hp % warrior.atk != 0 ) hits++;

                long damage = (hits - 1) * monster.atk;

                curHP += damage;
                maxHP = Math.max(maxHP, curHP);
            } else {
                warrior.atk += monster.atk;

                curHP -= monster.hp;

                if ( curHP < 0 ) curHP = 0;
            }

        }
    }

    static void output() throws IOException {
        bw.write(String.valueOf(maxHP + 1));
        bw.flush();
    }

    static class Warrior {
        long atk;

        public Warrior(int atk) {
            this.atk = atk;
        }
    }

    static class Dungeon {
        long type, atk, hp;

        public Dungeon(int type, int atk, int hp) {
            this.type = type;
            this.hp = hp;
            this.atk = atk;
        }
    }

}

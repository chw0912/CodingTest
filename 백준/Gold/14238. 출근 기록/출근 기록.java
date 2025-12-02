import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static String str;
    static int[] alphabet = new int[3];
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[][][][][] visited;


    public static void main(String[] args) throws IOException {
        input();
//        solve();
        output();
    }

    static void input() throws IOException {
        str = br.readLine();
        for (char c : str.toCharArray()) {
            if ( c == 'A' ) {
                alphabet[0]++;
            } else if ( c == 'B' ) {
                alphabet[1]++;
            } else {
                alphabet[2]++;
            }
        }

        visited = new boolean[alphabet[0]+1][alphabet[1]+1][alphabet[2]+1][3][3];
    }

//    static void solve() {
//    }

    static void output() throws IOException {
        dfs(0,0,0,0, 0, "");
        bw.write("-1");
        bw.flush();
    }

    static void dfs(int a, int b, int c, int prev, int pPrev, String s) {
        if (a == alphabet[0] && b == alphabet[1] && c == alphabet[2]) {
            out.println(s);
            System.exit(0);
            return;
        }
        if (visited[a][b][c][prev][pPrev]) return;

        visited[a][b][c][prev][pPrev] = true;

        if ( a < alphabet[0] ) {
            dfs(a+1, b, c, 0, prev, s+'A');
        }
        if ( b < alphabet[1] && prev != 1 ) {
            dfs(a, b+1, c, 1, prev, s+'B');
        }
        if ( c < alphabet[2]  && prev != 2 && pPrev != 2 ) {
            dfs(a, b, c+1, 2, prev, s+'C');
        }
    }


}

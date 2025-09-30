import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N; // 동희가 떡을 팔아야 할 날의 수
    static int M; // i번째 날 들고 가는 떡들의 개수
    static List<ArrayList<Integer>> riceCake = new ArrayList<>(); // 1-based
    static boolean[][] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+2][10]; // [떡 팔아야할 날][떡 번호]
        result = new int[N+1];

        riceCake.add(new ArrayList<>());
        for ( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();

            for ( int m = 0; m < M; m++ ) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            riceCake.add(list);
        }

    }

    static void solve() throws IOException {
        dfs(1,0);
    }

    static void output() throws IOException {
        bw.write("-1");
        bw.flush();
        bw.close();
    }

    static void dfs(int today, int yesterday) throws IOException {

        if ( today == N + 1 ) {
            for ( int i = 1; i <= N; i++ ) {
                bw.write(result[i] + "\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }

        for ( int rice : riceCake.get(today) ) {
            if ( !visited[today][rice] && rice != yesterday ) {
                visited[today][rice] = true;
                result[today] = rice;
                dfs(today + 1, rice);
            }

        }

    }
}

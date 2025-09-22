import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] arr;
    static List<Integer> list;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        arr = new int[3];
        for ( int i = 0; i < 3; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[arr[0]+1][arr[1]+1][arr[2]+1];
        list = new ArrayList<>();

        dfs(0, 0, arr[2]);

        list.sort(null);
        for ( int i = 0; i < list.size(); i++ ) {
            bw.write(String.valueOf(list.get(i)) + " ");
        }
        bw.flush();

    }

    public static void dfs(int a, int b, int c) {

        if ( visited[a][b][c] ) {
            return;
        }

        // a는 0일때
        if (a == 0) {
            // list에 포함하지 않는다면
            if ( !list.contains(c) ) {
                // c값 추가
                list.add(c);
            }
        }
        visited[a][b][c] = true;

        // A -> B
        if ( a + b <= arr[1] ) {
            dfs(0, a + b, c);
        } else {
            dfs(a+b - arr[1], arr[1], c);
        }

        // A -> C
        if ( a + c <= arr[2]) {
            dfs(0, b, a + c);
        } else {
            dfs(a+c - arr[2], b, arr[2]);
        }

        // B -> A
        if ( b + a <= arr[0]) {
            dfs(b+a, 0, c);
        } else {
            dfs(arr[0], b+a - arr[0], c);
        }
        // B -> C
        if ( b + c <= arr[2]) {
            dfs(a, 0, b + c);
        } else {
            dfs(a, b+c - arr[2], arr[2]);
        }

        // C -> A
        if ( c + a <= arr[0]) {
            dfs(a+c, b, 0);
        } else {
            dfs(arr[0], b, a+c - arr[0]);
        }

        // C -> B
        if ( c + b <= arr[1]) {
            dfs(a, b+c, 0);
        } else {
            dfs(a, arr[1], b+c - arr[1]);
        }
    }
}

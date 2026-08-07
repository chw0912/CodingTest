// [Gold 4] 1440. 가장 가까운 공통조상 찾기

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] parents;
    static int[] depths;
    static boolean[] visited;
    static int A, B, H;
    static int ans;
    static int rootNode; // 루트 노드를 저장할 변수

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        H = getHeight();

        depths = new int[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1][H];

        boolean[] hasParent = new boolean[N + 1]; // 루트를 찾기 위한 배열

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.get(x).add(y);
            hasParent[y] = true; // y는 누군가의 자식이 됨
        }

        // 부모가 없는 노드가 루트 노드
        for (int i = 1; i <= N; i++) {
            if (!hasParent[i]) {
                rootNode = i;
                break;
            }
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        // 무조건 1이 아닌, 찾은 루트 노드부터 탐색 시작
        dfs(rootNode, 0);
        setParents(H);

        ans = lca(A, B, H);
    }

    static int getHeight() {
        return (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        depths[node] = depth;
        for (int next : tree.get(node)) {
            if (visited[next]) continue;
            parents[next][0] = node;
            dfs(next, depth + 1);
        }
    }

    static void setParents(int h) {
        for (int i = 1; i < h; i++) {
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }
    }

    static int lca(int a, int b, int h) {
        if (depths[a] < depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = h - 1; i >= 0; i--) {
            if (depths[a] - depths[b] >= (1 << i)) {
                a = parents[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = h - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}

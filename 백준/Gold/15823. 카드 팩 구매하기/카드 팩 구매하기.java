import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // N : 진열된 카드의 수, M : 주띵이가 구매해야할 카드 팩의 수
    static int[] cards; // 입력으로 주어진 카드 번호
    static int[] visited; // visited[i] = k ->  i : 하나의 카드팩의 카드 수량, k : 구매 가능한 카드팩 수량
    static int ans; // 하나의 카드 팩에 구성할 수 있는 최대 수량

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        visited = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            cards[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(visited, M);
    }

    static void solve() {
        int i = 0, j = 0;

        Set<Integer> set = new HashSet<>();
        int size = 0;

        while (i != N && j != N) {
            if (!set.contains(cards[j])) {
                set.add(cards[j]);
                j++;
                size++;
            } else {
                set.remove(cards[i]);
                i++;
                size--;
            }
            visited[size]--;
        }

        for (int v = N; v >= 0; v--) {
            if(visited[v] <= 0) {
                ans = v;
                break;
            }
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int G, P;
    static int[] airplanes;
    static int[] parent;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        // P개의 비행기
        airplanes = new int[P];
        for (int i = 0; i < P; i++) {
            airplanes[i] = Integer.parseInt(br.readLine());
        }

        // union-find 알고리즘 사용하기 위한 배열
        // 배열 초기화 : 자기 자신은 빈 게이트
        parent = new int[G + 1];
        for (int i = 0; i < G + 1; i++) {
            parent[i] = i;
        }
    }

    static void solve() {
        for (int i = 0; i < P; i++) {
            int g = airplanes[i];

            // g번 게이트 이하에서 사용 가능한 큰 게이트
            int emptyGate = find(g);

            // 만약 0이면 도킹 불가 -> 공항 폐쇄
            if (emptyGate == 0) {
                break;
            }
            
            // 도킹 성공
            ans++;

            // 도킹 게이트를 바로 앞 게이트와 연결
            // 다음번 emptyGate를 찾으면 emptyGate - 1을 가리키게 됨
            union(emptyGate, emptyGate - 1);
        }
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }

    // x가 들어갈 수 있는 비어있는 게이트를 찾는 함수
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // 두 게이트를 연결하는 함수
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 더 작은 번호의 게이트를 부모로 설정
        if (x != y) {
            parent[x] = y;
        }
    }
}

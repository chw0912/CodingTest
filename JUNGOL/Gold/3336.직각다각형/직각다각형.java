import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // 오프셋과 최대 배열 크기 설정
    static final int OFFSET = 500_000;
    static final int MAX = 1_000_001;

    static int N;

    // [메모리 최적화] ArrayList의 배열로 선언합니다.
    static ArrayList<Integer>[] x = new ArrayList[MAX];
    static ArrayList<Integer>[] y = new ArrayList[MAX];

    static int[] h = new int[MAX];
    static int[] v = new int[MAX];
    static int maxH = 0, maxV = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken()) + OFFSET;
            int yi = Integer.parseInt(st.nextToken()) + OFFSET;

            // [메모리 최적화] 해당 좌표에 처음 값이 들어올 때만 리스트를 생성합니다 (지연 초기화)
            if (x[xi] == null) {
                x[xi] = new ArrayList<>();
            }
            x[xi].add(yi);

            if (y[yi] == null) {
                y[yi] = new ArrayList<>();
            }
            y[yi].add(xi);
        }
    }

    static void solve() {
        // 수직 방향 선분 겹침 계산
        for (int i = 0; i < MAX; i++) {
            // [메모리 최적화] 데이터가 없어 생성되지 않은(null) 곳은 건너뜁니다.
            if (x[i] == null) continue;

            Collections.sort(x[i]);

            for (int j = 0; j < x[i].size(); j += 2) {
                int start = x[i].get(j);
                int end = x[i].get(j + 1);

                for (int l = start; l < end; l++) {
                    h[l]++; // 기존 로직 유지: x배열 순회 시 h 갱신
                }
            }
        }

        // 수평 방향 선분 겹침 계산
        for (int i = 0; i < MAX; i++) {
            if (y[i] == null) continue;

            Collections.sort(y[i]);

            for (int j = 0; j < y[i].size(); j += 2) {
                int start = y[i].get(j);
                int end = y[i].get(j + 1);

                for (int l = start; l < end; l++) {
                    v[l]++; // 기존 로직 유지: y배열 순회 시 v 갱신
                }
            }
        }

        // 최댓값 탐색
        for (int i = 0; i < MAX; i++) {
            if (h[i] > maxH) maxH = h[i];
            if (v[i] > maxV) maxV = v[i];
        }
    }

    static void output() throws IOException {
        // 가로/세로 겹침 중 최댓값을 출력합니다.
        bw.write(Math.max(maxH, maxV) + "\n");
        bw.flush();
    }
}
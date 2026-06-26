import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, maxHeight, maxIdx;
    static int[] dp, parent;
    static List<Integer> result = new ArrayList<>();
    static ArrayList<Cube> cubes = new ArrayList<>();

    public static class Cube implements Comparable<Cube> {

        int id, bottom, height, weight;

        public Cube(int id, int bottom, int height, int weight) {
            this.id = id;
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Cube o) {
            return this.bottom - o.bottom;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        parent = new int[N+1];

        cubes.add(new Cube(0,0, 0, 0));

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cubes.add(new Cube(i, b, h, w));
        }

        Collections.sort(cubes);
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            dp[i] = cubes.get(i).height;
            parent[i] = i;

            for (int j = 0; j < i; j++) {
                // j번째 벽돌 위에 i번째 벽돌을 올릴 수 있는지 확인
                if (cubes.get(j).weight < cubes.get(i).weight) {
                    if (dp[i] < dp[j] + cubes.get(i).height) {
                        dp[i] = dp[j] + cubes.get(i).height;
                        parent[i] = j;
                    }
                }
            }

            if (maxHeight < dp[i]) {
                maxHeight = dp[i];
                maxIdx = i;
            }
        }

        int idx = maxIdx;

        while (idx != parent[idx]) {
            result.add(cubes.get(idx).id);
            idx = parent[idx];
        }
        result.add(cubes.get(idx).id);
    }

    static void output() throws IOException {
        bw.write(result.size() + "\n");

        for (int i = result.size()-1; i >= 0; i--) {
            bw.write(result.get(i) + "\n");
        }
        bw.flush();
    }
}


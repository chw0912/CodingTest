// [Gold 2] 1020. buildings

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int MAX_SIZE = 1_000_000_001;
    static int N;
    static int A, B, H;
    static List<Building> buildings = new ArrayList<>();
    static TreeSet<Integer> xSet = new TreeSet<>(); // 중복 제거 및 정렬을 위한 집합

    static List<Integer> xCoords = new ArrayList<>(); // X좌표를 리스트로 변환
    // 가장 높은 건물이 우선순위 1등이 되는 큐(Max Heap)
    static PriorityQueue<Building> pq = new PriorityQueue<>((b1, b2) -> b2.height - b1.height);

    static int bIdx; // buildings의 위치를 가르키는 인덱스
    static long ans;

    public static class Building implements Comparable<Building> {
        int start, end, height;

        public Building(int a, int b, int h) {
            this.start = a;
            this.end = b;
            this.height = h;
        }

        // 시작점 기준으로 오름차순 정렬
        @Override
        public int compareTo(Building o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            buildings.add(new Building(A, B, H));
            xSet.add(A);
            xSet.add(B);
        }

        Collections.sort(buildings);

    }

    static void solve() {

        // X좌표를 리스트로 변환
        xCoords = new ArrayList<>(xSet);

        // 징검다리를 하나씩 밟고 지나감
        for (int i = 0; i < xCoords.size() - 1; i++) {
            int currentX = xCoords.get(i);
            int nextX = xCoords.get(i+1);

            // 현재 좌표보다 작거나 같은 위치에서 시작하는 건물을 큐에 넣기
            while(bIdx < N && buildings.get(bIdx).start <= currentX) {
                pq.offer(buildings.get(bIdx));
                bIdx++;
            }

            // 큐의 1등 건물이 현재 좌표 기준으로 이미 끝난 건물이라면 버리기
            while(!pq.isEmpty() && pq.peek().end <= currentX) {
                pq.poll();
            }

            // 가장 높은 건물(큐의 1등)의 넓이를 계산하여 더하기
            if(!pq.isEmpty()) ans += (long) (nextX - currentX) * pq.peek().height;
        }

    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


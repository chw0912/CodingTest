// [Gold 5] 8468. 명당

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, K; // N : 구역의 개수, K : 최소 높이와 최대 높이의 차이
    static int left, last;
    static int[] place;
    // 최소힙 : 값이 작은 순서대로 정렬
    static PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
    // 최대힙 : 값이 큰 순서대로 정렬
    static PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.val, o1.val));

    public static class Node {
        int val, idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        place = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            place[n] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int right = 0; right < N; right++) {
            Node curr = new Node(place[right], right);
            minHeap.offer(curr);
            maxHeap.offer(curr);

            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek().val - minHeap.peek().val > K)) {
                left++;

                while(!maxHeap.isEmpty() && maxHeap.peek().idx < left) {
                    maxHeap.poll();
                }

                while(!minHeap.isEmpty() && minHeap.peek().idx < left) {
                    minHeap.poll();
                }
            }

            last = Math.max(last, right - left + 1);
        }
    }

    static void output() throws IOException {
        bw.write(last + "\n");
        bw.flush();
    }
}



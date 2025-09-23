import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int[] peoples; // 1-based
    static boolean[] visited; // 1-based
    static Map<Integer, List<Integer>> map; // 1-based
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new java.io.InputStreamReader(System.in));
        bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        peoples = new int[N+1];
        visited = new boolean[N+1];
        answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for ( int i = 1; i <= N; i++ ) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();

        for ( int i = 1; i <= N; i++ ) {
            st = new StringTokenizer(br.readLine());
            List<Integer> temp = new ArrayList<>();

            int n = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp.add(num);
            }
            map.put(i, temp);
        }

        dfs(1);

        if ( answer == Integer.MAX_VALUE ) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(answer));
        }
        bw.flush();
    }

    // A 선거구 B 선거구 구역 나누기
    static void dfs(int idx) {

        if ( idx == N ) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for ( int i = 1; i <= N; i++ ) {
                if ( visited[i] ) {
                    aList.add(i);
                } else {
                    bList.add(i);
                }
            }

            // 한 선거구만 존재할 경우
            if (aList.isEmpty() || bList.isEmpty()) {
                return;
            }

            // 각 선거구 별 인구수 계산하기
            if ( check(aList) && check(bList) ) {
                getPeopleAmount();
            }
            return;
        }


        visited[idx] = true;
        dfs(idx+1);

        visited[idx] = false;
        dfs(idx+1);


    }

    // 두 선거구가 연결 되어있는지 확인
    static boolean check(List<Integer> list) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(list.get(0));
        boolean[] newVisited = new boolean[N+1];
        newVisited[list.get(0)] = true;

        // 연결된 선거구의 수
        int count = 1;

        while ( !queue.isEmpty() ) {
            int current = queue.poll();

            for ( int next : map.get(current) ) {
                // 미방문 && list가 다음 노드를 포함한다면
                if ( !newVisited[next] && list.contains(next) ) {
                    queue.offer(next);
                    newVisited[next] = true;
                    count++;
                }
            }
        }

        // 해당 선거구의 실제 연결 수와 구한 선거구의 수와 같다면 true
        if ( count == list.size() ) {
            return true;
        }

        return false;
    }

    // 인구수 구하기
    static void getPeopleAmount() {

        int a = 0;
        int b = 0;

        for ( int i = 1; i <= N; i++ ) {
            if ( visited[i] ) {
                a += peoples[i];
            } else {
                b += peoples[i];
            }
        }

        int diff = Math.abs(a - b);
        answer = Math.min(answer, diff);

    }


    // 문제풀이
    // 전체 노드의 합 - 방문한 노드(A 선거구 인구수)의 합 = 방문하지 않은 노드(B 선거구 인구수)의 합
    // A 선거구와 B 선거구의 차이 계산
    // 여기서 두 선거구로 나눌 수 있는지 확인해야함
    // 두 선거구로 나눌 수 있다면 전체 노드의 합 - 방문한 노드의 합 ()
    // 두 선거구로 나눌 수 없는 경우
    // 1. 하나의 선거구만 나올 경우
    // 2. 세 개 이상의 선거구나 나올 경우(그림 3의 불가능한 방법같은 경우)


}

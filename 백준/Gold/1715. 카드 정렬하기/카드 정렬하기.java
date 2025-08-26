import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for ( int i = 0; i < N; i++ ) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while ( pq.size() > 1 ) {
            int a = pq.poll();
            int b = pq.poll();

            result += a + b;
            pq.offer(a + b);
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
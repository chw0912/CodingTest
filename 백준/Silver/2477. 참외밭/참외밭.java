import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int maxH = 0, maxW = 0;
        int maxHIdx = 0, maxWIdx = 0;

        int[] dirs = new int[6];
        int[] dists = new int[6];

        for ( int i = 0; i < 6; i++ ) {
            st = new StringTokenizer(br.readLine());
            dirs[i] = Integer.parseInt(st.nextToken());
            dists[i] = Integer.parseInt(st.nextToken());

            if ( dirs[i] == 1 || dirs[i] == 2 ) {
                if ( maxW < dists[i] ) {
                    maxW = dists[i];
                    maxWIdx = i;
                }
            } else if ( dirs[i] == 3 || dirs[i] == 4 ) {
                if ( maxH < dists[i] ) {
                    maxH = dists[i];
                    maxHIdx = i;
                }
            }
        }
        int maxArea = maxH * maxW;
        int minArea = dists[(maxHIdx + 3) % 6] * dists[(maxWIdx + 3) % 6];

        bw.write(String.valueOf((maxArea - minArea) * N));
        bw.flush();

    }
}

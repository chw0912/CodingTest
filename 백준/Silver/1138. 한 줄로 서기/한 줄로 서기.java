import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        for ( int i = 0; i < N; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for ( int i = 0; i < N; i++ ) {
            int idx = arr[i];
            int tall = arr[i];
            int count;

            if ( result[idx] == 0 ) {
                while ( true ) {
                    count = getCount(result, idx, i);
                    if ( count >= tall && result[idx] == 0) {
                        result[idx] = i + 1;
                        break;
                    } else {
                        idx++;
                    }
                }
            } else {
                while ( true ) {
                    count = getCount(result, idx, i);
                    if ( count >= tall && result[idx] == 0 ) {
                        result[idx] = i + 1;
                        break;
                    } else {
                        idx++;
                    }
                }
            }
        }

        for ( int i = 0; i < N; i++ ) {
            bw.write(String.valueOf(result[i]));
            bw.write(" ");
        }
        bw.flush();
    }

    private static int getCount(int[] result, int idx, int i) {
        int[] tmp = Arrays.copyOfRange(result, 0, idx);
        int count = 0; // 자신보다 크거나 0
        for ( int j = 0; j < tmp.length; j++ ) {
            if ( tmp[j] > i || tmp[j] == 0 ) {
                count++;
            }
        }
        return count;
    }


}

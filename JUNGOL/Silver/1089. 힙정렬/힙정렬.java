import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        if(m == 1) {
            for(int i = 0; i < n; i++) {
                sb.append(arr[i]).append("\n");
            }
        }
        else {
            for(int i = n - 1; i >= 0; i--) {
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
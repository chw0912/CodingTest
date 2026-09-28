// [Silver 1] 1231. 휴대폰번호 정렬

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] order;
    static PhoneNumber[] list;
    static StringBuilder sb = new StringBuilder();

    // 휴대폰 번호 정보를 저장할 클래스 정의
    static class PhoneNumber implements Comparable<PhoneNumber> {
        String fullNumber; // 원본 번호 (출력용)
        int prefixIdx;     // 문제에서 정의한 국번의 우선순위 (index)
        String middle;        // 중간 번호 (숫자 비교용)
        String last;          // 뒷자리 번호 (숫자 비교용)

        public PhoneNumber(String fullNumber) {
            this.fullNumber = fullNumber;

            // 하이픈(-)을 기준으로 분리하여 국번, 중간번호, 뒷번호 추출
            String[] parts = fullNumber.split("-");
            String prefix = parts[0];
            this.middle = parts[1];
            this.last = parts[2];

            // 국번의 마지막 자리 숫자(010->0, 011->1 등)로 매핑된 우선순위 찾기
            int prefixDigit = prefix.charAt(2) - '0';
            this.prefixIdx = order[prefixDigit];
        }

        @Override
        public int compareTo(PhoneNumber o) {
            // 1. 국번 우선순위 기준 정렬
            if (this.prefixIdx != o.prefixIdx) {
                return Integer.compare(this.prefixIdx, o.prefixIdx);
            }
            // 2. 중간 번호 기준 정렬
            if (!this.middle.equals(o.middle)) {
                if (this.middle.length() != o.middle.length()) {
                    return Integer.compare(o.middle.length(), this.middle.length());
                }
                return this.middle.compareTo(o.middle);
            }
            // 3. 뒷자리 번호 기준 정렬
            if (!this.last.equals(o.last)) {
                if (this.last.length() != o.last.length()) {
                    return Integer.compare(o.last.length(), this.last.length());
                }
                return this.last.compareTo(o.last);
            }
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        order = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            order[num] = i;
        }

        list = new PhoneNumber[N];
        for (int i = 0; i < N; i++) {
            list[i] = new PhoneNumber(br.readLine().trim());
        }
    }

    static void solve() {

        // 휴대폰번호 순서대로 정렬
        Arrays.sort(list);

        for (PhoneNumber phone : list) {
            sb.append(phone.fullNumber).append("\n");
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


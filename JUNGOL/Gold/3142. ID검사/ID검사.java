package jungol._3142;

// [Gold 4] ID검사

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int active;
    static HashMap<String, Boolean> members = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int result;
            switch (command) {
                case 1 -> {
                    result = validate(st.nextToken());
                    sb.append(result).append("\n");
                }
                case 2 -> {
                    result = activate(st.nextToken());
                    sb.append(result).append("\n");
                }
                case 3 -> {
                    result = signup(st.nextToken());
                    sb.append(result).append("\n");
                }
                case 4 -> {
                    result = close(st.nextToken());
                    sb.append(result).append("\n");
                }
                case 5 -> {
                    result = login(st.nextToken());
                    sb.append(result).append("\n");
                }
                case 6 -> {
                    result = logout(st.nextToken());
                    sb.append(result).append("\n");
                }
            }
        }

    }

    static void solve() {

    }

    // 명령 1 : int validate(char* ID)
    // ID가 이미 가입되어 있다면 1을, 그렇지 않다면 0을 반환한다.
    static int validate(String ID) {
        if (members.containsKey(ID)) {
            return 1;
        }
        return 0;
    }

    // 명령 2 : int activate(char* ID)
    // ID가 로그인 중이라면 1을, 그렇지 않다면 0을 반환한다.
    static int activate(String ID) {
        if (members.containsKey(ID) && members.get(ID)) {
            return 1;
        }
        return 0;
    }

    // 명령 3 :int signup(char*ID)
    // 새로운 ID이라면 등록하고 현재 등록 중인 회원 수를 반환한다.
    // 등록만 되고 자동으로 로그인되지 않는다는 것에 유의하자.
    // 이미 등록된 ID라면 현재 등록 중인 회원 수만 반환한다.
    static int signup(String ID) {
        if (members.containsKey(ID)) {
            return members.size();
        }
        members.put(ID, false);
        return members.size();
    }

    // 명령 4 : int close(char*ID)
    // ID가 등록된 회원이라면 탈퇴 처리한다.
    // 등록된 회원이 로그인 되어 있다면 탈퇴와 동시에 로그아웃도 처리되어야 한다.
    // 등록된 회원이 아니라면 아무 일도 하지 않는다.
    // 현재 등록 중인 회원 수를 반환한다.
    static int close(String ID) {
        // 로그아웃 처리 후 탈퇴처리
        logout(ID);
        members.remove(ID);
        return members.size();
    }

    // 명령 5 : int login(char*ID)
    // ID가 등록된 회원이고 로그아웃된 상태라면 로그인 처리한다.
    // 그렇지 않다면 아무 일도 하지 않는다.
    // 현재 로그인 중인 회원 수를 반환한다.
    static int login(String ID) {
        if (members.containsKey(ID) && !members.get(ID)) {
            members.put(ID, true);
            active++;
        }
        return active;
    }

    // 명령 6 : int logout(char*ID)
    // ID가 로그인 된 회원이라면 로그아웃 처리한다.
    // 그렇지 않다면 아무 일도 하지 않는다.
    // 현재 로그인 중인 회원 수를 반환한다.
    static int logout(String ID) {
        if (members.containsKey(ID) && members.get(ID)) {
            members.put(ID, false);
            active--;
        }

        return active;
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


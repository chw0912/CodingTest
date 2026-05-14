# D4. 러시아 국기 같은 깃발

T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())

    flags = [list(input()) for _ in range(N)]

    ans = N*M

    all = N * M
    W = [0 for _ in range(N)]
    B = [0 for _ in range(N)]
    R = [0 for _ in range(N)]

    for i in range(N):
        if i < N - 2:
            W[i] = flags[i].count("W")

        if i < N - 1:
            B[i] = flags[i].count("B")

        R[i] = flags[i].count("R")

    for i in range(N-2):
        for j in range(i+1, N-1):
            temp = sum(W[:i+1]) + sum(B[i+1:j+1]) + sum(R[j+1:])
            ans = min(ans,all - temp)


    print(f'#{t} {ans}')
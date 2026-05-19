# D3. 전기버스2

T = int(input())

for t in range(1, T+1):
    inp = list(map(int, input().split()))
    N = inp[0]
    M = inp[1:]

    inf = float('inf')
    dp = [inf] * (N + 1)

    dp[1] = 0

    for i in range(1, N):
        battery = M[i-1]

        if dp[i] == inf:
            continue

        for j in range(i+1, min(i + battery + 1, N + 1)):
            if dp[j] > dp[i] + 1:
                dp[j] = dp[i] + 1

    print(f'#{t} {dp[N] - 1}')

# Silver 2 1535. 안녕

N = int(input())
stamina = [0] + list(map(int, input().split()))

pleasure = [0] + list(map(int, input().split()))

dp = [[0] * 101 for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,101):
        if stamina[i] <=j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-stamina[i]] + pleasure[i])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][99])
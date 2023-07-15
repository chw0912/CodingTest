# Silver 1 1495. 기타리스트

N, S, M = map(int, input().split())

v = list(map(int, input().split()))

dp = [[0] * (M+1) for _ in range(N+1)]

dp[0][S] = 1

for i in range(N):
    for j in range(M+1):
        if dp[i][j] == 1:
            if j + v[i] <= M:
                dp[i+1][j+v[i]] = 1
            if j - v[i] >= 0:
                dp[i+1][j-v[i]] = 1

ans = -1
for i in range(M,-1,-1):
    if dp[N][i] == 1:
        ans = i
        break
print(ans)
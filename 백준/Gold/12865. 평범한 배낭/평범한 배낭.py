# Gold 5. 평범한 배낭
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

items = [[0, 0]]
dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

for _ in range(N):
    items.append(list(map(int, input().split())))

for i in range(1, N+1):
    w = items[i][0]
    v = items[i][1]
    for j in range(1, K + 1):
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
            
print(dp[N][K])
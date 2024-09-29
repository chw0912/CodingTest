# Gold 5. 평범한 배낭
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

items = [list(map(int, input().split())) for _ in range(N)]
dp = [0 for _ in range(K + 1)]

for item in items:
    w, v = item
    for i in range(K, w-1, -1):
        dp[i] = max(dp[i], dp[i-w]+v)
print(dp[-1])
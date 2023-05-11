T = int(input())

for t in range(1, T+1):
    N = int(input())
    scores = list(map(int, input().split()))
    lim = sum(scores)
    dp = [0] * (lim + 1)
    dp[0] = 1

    for s in scores:
        for i in range(lim,-1,-1):
            if dp[i]:
                dp[i+s] = 1
    print(f'#{t} {dp.count(1)}')

# Silver 4. 동전 0

N, K = map(int, input().split())
coins = []

for i in range(0, N):
    coins.append(int(input()))

coins.sort(reverse=True)
count = 0

for coin in coins:
    if K >= coin:
        div, K = divmod(K, coin)
        count += div
        if K <= 0:
            break
print(count)
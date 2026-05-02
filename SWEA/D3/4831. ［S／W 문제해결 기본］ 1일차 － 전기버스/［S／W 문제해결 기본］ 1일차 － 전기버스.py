# D3. 전기버스
T = int(input())

for t in range(1, T+1):
    K, N, M = map(int, input().split())
    ans = 0

    charger = list(map(int, input().split()))

    cur = 0

    while cur + K < N:
        for step in range(K, 0, -1):
            if (cur + step) in charger:
                cur += step
                ans += 1
                break
        else:
            ans = 0
            break
            
    print(f'#{t} {ans}')
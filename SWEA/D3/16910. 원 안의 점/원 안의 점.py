T = int(input())

for t in range(1,T+1):
    N = int(input())
    ans = 0

    for x in range(-N, N+1):
        for y in range(-N, N+1):
            if x**2 + y**2 <= N**2:
                ans += 1
    print(f'#{t} {ans}')
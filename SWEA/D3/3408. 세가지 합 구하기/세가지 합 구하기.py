T = int(input())
for t in range(1, T+1):
    N = int(input())

    S1 = (N + 1) * N // 2
    S2 = N ** 2
    S3 = (N + 1) * N

    print(f'#{t} {S1} {S2} {S3}')

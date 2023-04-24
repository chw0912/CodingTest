T = int(input())

for t in range(1,T+1):
    N = int(input())

    per = list(map(int, input().split()))

    avg = sum(per)/N
    cnt = 0

    for n in range(N):
        if per[n] <= avg:
            cnt += 1

    print(f'#{t} {cnt}')
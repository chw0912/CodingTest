T = int(input())

for t in range(1, T+1):
    N = int(input())
    arr = list(input().split())

    shuffle = [0 for _ in range(N)]

    if N % 2 == 0:
        idx1 = 0
        idx2 = N // 2
        for j in range(N):
            if j % 2 == 0:
                shuffle[j] = arr[idx1]
                idx1 += 1
            else:
                shuffle[j] = arr[idx2]
                idx2 += 1
    else:
        idx1 = 0
        idx2 = N // 2 + 1
        for j in range(N):
            if j % 2 == 0:
                shuffle[j] = arr[idx1]
                idx1 += 1
            else:
                shuffle[j] = arr[idx2]
                idx2 += 1
    print(f'#{t}', *shuffle)
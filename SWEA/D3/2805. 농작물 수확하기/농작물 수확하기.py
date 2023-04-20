T = int(input())

for t in range(1, T+1):
    N = int(input())

    arr = [list(map(int,input())) for _ in range(N)]
    k = N // 2
    c = 1
    i =0
    ans = 0

    # i < k
    for j in range(k, 0, -1):
        ans += sum(arr[i][j:j+c])
        i += 1
        c += 2

    # i = k
    ans += sum(arr[i])
    i += 1

    # i > k
    for j in range(1, k+1, 1):
        c -= 2
        ans += sum(arr[i][j:j+c])
        i += 1


    print(f'#{t} {ans}')
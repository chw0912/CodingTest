T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())
    bin_M = M
    for i in range(N):
        if bin_M % 2 == 1:
            bin_M = bin_M // 2
        elif bin_M % 2 == 0:
            print(f'#{t} OFF')
            break
    else:
        print(f'#{t} ON')
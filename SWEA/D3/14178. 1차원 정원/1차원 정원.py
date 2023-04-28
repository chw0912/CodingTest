T = int(input())

for t in range(1, T+1):
    N, D = map(int, input().split())

    d = D * 2 + 1
    ans = 0
    if N % d == 0:
        ans = N//d
    else:
        ans = N//d + 1

    print(f'#{t} {ans}')

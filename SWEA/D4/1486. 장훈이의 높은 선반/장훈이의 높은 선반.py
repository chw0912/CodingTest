from itertools import combinations

T = int(input())

for t in range(1, T+1):
    N, B = map(int, input().split())
    arr = sorted(list(map(int, input().split())))

    nCr = 987654321

    for i in range(1,N+1):
        for j in combinations(arr, i):
            if sum(j) >= B:
                nCr = min(nCr, sum(j))
    print(f'#{t} {nCr-B}')
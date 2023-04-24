T = int(input())

for t in range(1, T+1):
    N = int(input())

    print(f'#{t}', end=' ')
    for _ in range(N):
        print(f'{1}/{N}', end=' ')
    print()
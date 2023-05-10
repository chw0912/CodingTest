T = int(input())

for t in range(1, T+1):
    N = int(input())

    names = [input() for _ in range(N)]

    names = list(set(names))
    a = sorted(names, key=lambda x: (len(x), x))

    print(f'#{t}')
    for name in a:
        print(f'{name}')
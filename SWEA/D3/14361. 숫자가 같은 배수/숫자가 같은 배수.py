T = int(input())

for t in range(1, T+1):
    N = int(input())

    i = 2
    while len(str(N*i)) == len(str(N)):
        if sorted(str(N)) == sorted(str(N*i)):
            print(f'#{t} possible')
            break
        i += 1
    else:
        print(f'#{t} impossible')
    
T = int(input())

for t in range(1, T+1):
    N = int(input())
    for i in range(1, 10):
        if len(str(N//i)) < 2 and (N//i)*i == N:
            print(f'#{t} Yes')
            break
    else:
        print(f'#{t} No')
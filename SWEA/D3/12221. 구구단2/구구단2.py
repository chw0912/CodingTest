T = int(input())

for t in range(1, T+1):
    A, B = map(int, input().split())

    if A >= 10 or B >= 10:
        print(f'#{t} -1')
        continue
    print(f'#{t} {A*B}')
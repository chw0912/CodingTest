T = 10

for t in range(1,T+1):
    n = int(input())

    a, b = map(int, input().split())

    print(f'#{t} {a**b}')
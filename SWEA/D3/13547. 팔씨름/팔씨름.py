T = int(input())

for t in range(1, T+1):
    Odds = input()

    if Odds.count('x') <= 7:
        print(f'#{t} YES')
    else:
        print(f'#{t} NO')
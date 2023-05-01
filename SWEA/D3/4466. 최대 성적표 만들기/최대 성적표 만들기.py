T = int(input())

for t in range(1, T+1):
    N, K = map(int, input().split())
    grade = sorted(list(map(int, input().split())))

    print(f'#{t} {sum(grade[len(grade)-K:])}')



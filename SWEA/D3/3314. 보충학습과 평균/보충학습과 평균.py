T = int(input())

for t in range(1, T+1):
    score = list(map(int, input().split()))

    for s in range(len(score)):
        if score[s] < 40:
            score[s] = 40

    print(f'#{t} {sum(score)//len(score)}')
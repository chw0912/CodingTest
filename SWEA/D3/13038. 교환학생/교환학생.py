T = int(input())

for t in range(1, T+1):
    n = int(input())
    weeks = list(map(int, input().split()))
    days = []
    for j in range(7):
        a = n
        i = j
        cnt = 1
        while a != 0:
            if weeks[i] == 1:
                a -= 1
            i += 1
            if i >= 7:
                cnt += 1
                i = 0
        days.append(cnt * 7 - ((7-i) + j))
    print(f'#{t} {min(days)}')




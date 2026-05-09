# D4. 자기 방으로 돌아가기

T = int(input())

for t in range(1, T+1):
    N = int(input())
    ans = 0
    room = [0 for _ in range(401)]

    for _ in range(N):
        start, arrive = map(int, input().split())

        # swap
        if start > arrive:
            start, arrive = arrive, start

        if start % 2 == 0:
            start -= 1

        if arrive % 2 == 1:
            arrive += 1

        for i in range(start, arrive + 1):
            room[i] += 1

    for i in range(401):
        if room[i] > ans:
            ans = room[i]

    print(f'#{t} {ans}')
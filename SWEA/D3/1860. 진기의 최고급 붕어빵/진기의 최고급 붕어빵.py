T = int(input())

result = list()

for t in range(1, T+1):

    N, M, K = map(int, input().split())

    arrive = sorted(list(map(int, input().split())))

    complete = 0

    time = 0
    idx = 0

    while idx != N:
        if time % M == 0 and time != 0:
            complete += K

        if time >= arrive[idx]:
            if complete >= 1:
                complete -= 1
                idx += 1
            else:
                print(f"#{t} Impossible")
                break

        time += 1
    else:
        print(f"#{t} Possible")

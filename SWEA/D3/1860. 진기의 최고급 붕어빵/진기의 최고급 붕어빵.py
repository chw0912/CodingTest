#D3. 진기의 최고급 붕어빵

T = int(input())

for t in range(1, T+1):
    N, M, K = map(int, input().split())

    arrive = sorted(list(map(int, input().split())))

    idx = 0
    time = 0
    fish_cake = 0
    flag = True

    while time <= arrive[-1]:

        if time != 0 and time % M == 0:
            fish_cake += K

        if arrive[idx] == time:
            fish_cake -= 1
            idx += 1
            if fish_cake < 0:
                flag = False
                break
        time += 1

    if flag:
        print(f"#{t} Possible")
    else:
        print(f"#{t} Impossible")

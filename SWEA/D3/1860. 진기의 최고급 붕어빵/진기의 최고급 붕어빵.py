T = int(input())

for t in range(1,T+1):

    # N = 사람 수, M = 초, K = 초당 만들 수 있는 붕어빵 개수
    N, M, K = map(int, input().split())
    # 붕어빵 사러 오는 시간
    time = sorted(list(map(int, input().split())))

    ans = 0
    flag = True
    for i in range(0, time[-1]+1):
        if i % M == 0 and i != 0:
            ans += K
        for j in range(len(time)):
            if time[j] == i and ans >= 1:
                ans -= 1
            elif time[j] == i and ans < 1:
                flag = False
                break
        if not flag:
            break

    if not flag:
        print(f'#{t} Impossible')
    else:
        print(f'#{t} Possible')
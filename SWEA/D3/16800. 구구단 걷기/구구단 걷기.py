# 16800. 구구단 걷기

T = int(input())

for t in range(1,T+1):
    N = int(input())
    lst = []

    for n in range(1, int(N ** 0.5)+1):
        if N % n == 0:
            lst.append((n, N//n))

    for i,(x,y) in enumerate(lst):
        lst[i] = (x-1)+(y-1)
    print(f'#{t} {min(lst)}')


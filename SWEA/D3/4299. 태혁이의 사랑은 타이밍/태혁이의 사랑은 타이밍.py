T = int(input())

for t in range(1, T+1):
    D, H, M = map(int, input().split())
    m = ((D-11)*24 + (H-11))*60 + M-11
    if m >= 0:
        print(f'#{t} {m}')
    else:
        print(f'#{t} -1')
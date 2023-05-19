# 4111 무선 단속 카메라

T = int(input())

for t in range(1, T+1):
    N = int(input())
    K = int(input())
    arr = sorted(list(set(map(int, input().split()))))
    ans = 0

    diff = sorted([arr[i+1]-arr[i] for i in range(len(arr)-1)])

    if K >= N:
        print(f'#{t} {ans}')
    else:
        ans = sum(diff[:len(diff)-(K-1)])
        print(f'#{t} {ans}')
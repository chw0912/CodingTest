T = int(input())

for t in range(1, T+1):
    N, A, B = map(int, input().split())

    max_num = min(A, B)
    min_num = A + B - N

    if min_num <= 0:
        print(f'#{t} {max_num} 0')
    else:
        print(f'#{t} {max_num} {min_num}')
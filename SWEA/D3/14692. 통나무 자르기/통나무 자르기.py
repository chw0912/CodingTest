# 14692. 통나무 자르기

T = int(input())

for t in range(1, T+1):
    N = int(input())

    if N % 2 == 0:
        print(f'#{t} Alice')
    else:
        print(f'#{t} Bob')


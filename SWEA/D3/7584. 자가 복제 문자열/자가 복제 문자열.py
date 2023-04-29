T = int(input())

for t in range(1, T+1):
    K = int(input())-1


    while True:
        if K % 2 == 1:
            K = (K-1)//2

        if K % 4 == 0:
            print(f'#{t} 0')
            break
        elif K % 2 == 0:
            print(f'#{t} 1')
            break
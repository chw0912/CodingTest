# 별 찍기 - 2

T = int(input())

for i in range(T):
    for j in range(T):
        if T-1-i <= j:
            print('*',end='')
        else:
            print(' ',end='')
    print('')


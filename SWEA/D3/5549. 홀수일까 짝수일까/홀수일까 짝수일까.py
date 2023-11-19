# 5549. 홀수일까 짝수일까

T = int(input())

for t in range(1, T+1):
    N = input()
    
    if int(N[-1]) % 2 == 0:
        print(f'#{t} Even')
    else:
        print(f'#{t} Odd')
    
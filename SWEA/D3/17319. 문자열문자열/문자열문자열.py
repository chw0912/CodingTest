# 문자열문자열 17319

T = int(input())

for t in range(1, T+1):
    N = int(input())
    S = input()

    if N % 2 != 0:
        print(f'#{t} No')
    else:
        if S[:N//2] == S[N//2:]:
            print(f'#{t} Yes')
        else:
            print(f'#{t} No')

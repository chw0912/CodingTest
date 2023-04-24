T = int(input())

for t in range(1, T+1):
    case = input()
    a,b = 1, 1
    for tc in case:
        if tc == 'L':
            a = a
            b = a+b
        else:
            a = a+b
            b = b
    print(f'#{t} {a} {b}')
T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())

    arr = [input() for _ in range(N)]

    my_dict = { '0001101':0,'0011001':1,'0010011':2,'0111101':3,'0100011':4,
                '0110001':5, '0101111':6, '0111011':7, '0110111':8, '0001011':9}

    code = ''
    str_code = []
    for i in range(len(arr)):
        if sum(map(int,list(arr[i]))) != 0:
            v_code = arr[i]
            for j in range(M-1,-1,-1):
                if arr[i][j] == '1':
                    code = v_code[j-55:j+1]
                    break
            break

    for j in range(0,56,7):
        str_code += [code[j:j+7]]

    for i in range(len(str_code)):
        if str_code[i] in my_dict:
            str_code[i] = my_dict[str_code[i]]
    a = 0
    for i in range(len(str_code)):
        if i % 2 == 0:
            a += str_code[i]*3
        else:
            a += str_code[i]
    if a % 10 == 0:
        print(f'#{t} {sum(str_code)}')
    else:
        print(f'#{t} 0')


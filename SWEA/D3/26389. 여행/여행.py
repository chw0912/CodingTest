T = int(input())

for _ in range(T):
    command = list(input())

    ns = [False, False]
    ew = [False, False]

    for d in command:
        if d == 'N':
            ns[0] = True

        if d == 'E':
            ew[0] = True

        if d == 'W':
            ew[1] = True

        if d == 'S':
            ns[1] = True

    if ns.count(True) % 2 == 1:
        print('No')
    elif ew.count(True) % 2 == 1:
        print('No')
    else:
        print('Yes')

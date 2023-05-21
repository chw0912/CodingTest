T = int(input())

for t in range(1,T+1):
    command = input()
    N = int(command.split(' ')[0])
    command = command.split(' ')[1:]
    pos = [1, 1]
    B = []
    O = []

    for i in range(len(command)):
        if command[i] == 'B':
            B.append(int(command[i+1]))
        elif command[i] == 'O':
            O.append(int(command[i+1]))

    time = 0
    while command:
        if command[0] == 'B':
            if pos[0] < int(command[1]):
                pos[0] += 1
            elif pos[0] > int(command[1]):
                pos[0] -= 1
            elif pos[0] == int(command[1]):
                command.pop(0)
                command.pop(0)
                B.pop(0)

            if len(O) != 0:
                if pos[1] < O[0]:
                    pos[1] += 1
                elif pos[1] > O[0]:
                    pos[1] -= 1
                else:
                    pass

        elif command[0] == 'O':
            if pos[1] < int(command[1]):
                pos[1] += 1
            elif pos[1] > int(command[1]):
                pos[1] -= 1
            elif pos[1] == int(command[1]):
                command.pop(0)
                command.pop(0)
                O.pop(0)

            if len(B) != 0:
                if pos[0] < B[0]:
                    pos[0] += 1
                elif pos[0] > B[0]:
                    pos[0] -= 1
                else:
                    pass
        time += 1
    print(f'#{t} {time}')
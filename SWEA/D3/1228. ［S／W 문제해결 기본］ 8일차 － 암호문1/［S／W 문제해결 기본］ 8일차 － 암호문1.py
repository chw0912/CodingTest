T = 10

for t in range(1, T+1):
    N = int(input())
    code = list(map(int, input().split()))
    M = int(input())
    commands = list(input().split())

    for i in range(len(commands)):
        if commands[i] == 'I':
            idx = int(commands[i+1])
            num = int(commands[i+2])
            for j in range(num):
                code.insert(idx+j, commands[i+3+j])
    print(f"#{t}", *code[:10])
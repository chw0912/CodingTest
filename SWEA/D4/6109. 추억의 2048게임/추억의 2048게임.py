from collections import  deque
def push(arr):
    tmp = []
    flag = False
    for i in arr:
        if i == 0:
            continue
        if tmp:
            if tmp[-1] == i and not flag:
                tmp[-1] += i
                flag = True
            else:
                tmp.append(i)
                flag = False
        else:
            tmp.append(i)

    for i in range(int(N)-len(tmp)):
        tmp.append(0)

    return tmp



# up, down, left, right
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
dir = ['up', 'down', 'left', 'right']

T = int(input())

for t in range(1, T+1):
    N, S = input().split()

    maps = [list(map(int, input().split())) for _ in range(int(N))]
    cols = list(map(list,zip(*maps)))

    arr = []
    print(f'#{t}')
    # left일 떄
    if S == 'left':
        for i in range(int(N)):
            arr.append(push(maps[i]))
        for i in range(int(N)):
            print(*arr[i])
    # right
    elif S == 'right':
        for i in range(int(N)):
            arr.append(push(maps[i][int(N)-1::-1]))
        for i in range(int(N)):
            print(*arr[i][int(N)::-1])
    # up
    elif S == 'up':
        for i in range(int(N)):
            arr.append(push(cols[i]))

        for i in range(int(N)):
            for j in range(int(N)):
                print(arr[j][i], end=' ')
            print()

    elif S == 'down':
        for i in range(int(N)):
            arr.append(push(cols[i][int(N)::-1]))

        for i in range(int(N)-1,-1,-1):
            for j in range(int(N)):
                print(arr[j][i],end=' ')
            print()




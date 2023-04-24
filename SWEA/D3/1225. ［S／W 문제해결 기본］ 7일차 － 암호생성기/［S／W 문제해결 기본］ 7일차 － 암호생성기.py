from collections import deque
T = 10

for t in range(1,T+1):
    tc = int(input())
    queue2 = deque(list(map(int, input().split())), maxlen=8)

    i = 1
    while True:
        if i > 5:
            i = 1
        q = queue2.popleft() - i
        if q <= 0:
            queue2.append(0)
            break
        queue2.append(q)
        i += 1
    print(f'#{tc}', end=' ')
    for q in queue2:
        print(f'{q}', end=' ')
    print()
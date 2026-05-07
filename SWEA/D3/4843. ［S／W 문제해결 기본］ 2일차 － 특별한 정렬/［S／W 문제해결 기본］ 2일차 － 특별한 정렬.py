from collections import deque
# D3. 특별한 정렬

T = int(input())

for t in range(1, T+1):
    N = int(input())

    numbers = sorted(list(map(int, input().split())))

    dq = deque(numbers)
    result = []

    while dq:
        result.append(dq.pop())

        if dq:
            result.append(dq.popleft())



    print(f'#{t}', end=' ')
    for i in range(10):
        print(result[i], end=' ')
    print()
# Silver 3. 프린터 큐

import sys
from collections import deque

input = sys.stdin.readline


T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    dq = deque(list(map(int, input().split())))
    count = 0

    while dq:
        best = max(dq)
        first = dq.popleft()
        M -= 1

        if best == first:
            count += 1
            if M < 0:
                print(count)
                break
        else:
            dq.append(first)
            if M < 0:
                M = len(dq) - 1
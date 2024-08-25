# Silver 4. 큐
import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())

dq = deque()

for _ in range(N):
    command = input().rstrip()
    if "push" in command:
        dq.append(command.split()[1])
    elif "pop" == command:
        if dq:
            pop_num = dq.popleft()
            print(pop_num)
        else:
            print(-1)
    elif "size" == command:
        print(len(dq))
    elif "empty" == command:
        if dq:
            print(0)
        else:
            print(1)
    elif "front" == command:
        if dq:
            print(dq[0])
        else:
            print(-1)
    elif "back" == command:
        if dq:
            print(dq[-1])
        else:
            print(-1)